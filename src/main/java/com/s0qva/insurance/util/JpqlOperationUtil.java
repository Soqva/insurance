package com.s0qva.insurance.util;

import com.s0qva.insurance.constant.JpqlConstant;
import com.s0qva.insurance.exception.EntityAliasNotFoundException;
import com.s0qva.insurance.exception.InvalidJpqlQueryException;
import com.s0qva.insurance.exception.SetClauseNotFoundException;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;

@UtilityClass
public class JpqlOperationUtil {
    private static final String UPDATE_DELETE_JPQL_OPERATION_REGEX = "(?:update|delete from)\\s" +
            "(?<entity>\\w+)\\s?" +
            "(?<alias>\\w)?";
    private static final String ENTITY_GROUP_NAME = "entity";
    private static final String ALIAS_GROUP_NAME = "alias";

    public String convertToSelectJpqlQuery(String jpqlQuery) {
        String entity = extractEntity(jpqlQuery);
        String entityAlias = extractEntityAlias(jpqlQuery);
        String whereClause = StringUtils.EMPTY;

        if (Objects.isNull(entityAlias)) {
            throw new EntityAliasNotFoundException();
        }
        int whereClauseIndex = jpqlQuery.indexOf(JpqlConstant.WHERE_CLAUSE_NAME);

        if (whereClauseIndex != StringUtils.INDEX_NOT_FOUND) {
            whereClause = jpqlQuery.substring(whereClauseIndex);
        }
        return JpqlConstant.SELECT_OPERATION_NAME
                + StringUtils.SPACE
                + entityAlias
                + " from "
                + entity
                + StringUtils.SPACE
                + entityAlias
                + StringUtils.SPACE
                + whereClause;
    }

    public Map<String, String> extractChanges(String jpqlQuery) {
        Map<String, String> changes = new HashMap<>();
        String entityAlias = extractEntityAlias(jpqlQuery);

        if (Objects.isNull(entityAlias)) {
            throw new EntityAliasNotFoundException();
        }
        int setClauseIndex = jpqlQuery.indexOf(JpqlConstant.SET_CLAUSE_NAME);

        if (setClauseIndex == StringUtils.INDEX_NOT_FOUND) {
            throw new SetClauseNotFoundException();
        }
        String setClause;
        int whereClauseIndex = jpqlQuery.indexOf(JpqlConstant.WHERE_CLAUSE_NAME);

        if (whereClauseIndex != StringUtils.INDEX_NOT_FOUND) {
            setClause = jpqlQuery.substring(setClauseIndex + JpqlConstant.SET_CLAUSE_NAME.length() + 1, whereClauseIndex - 1);
        } else {
            setClause = jpqlQuery.substring(setClauseIndex + JpqlConstant.SET_CLAUSE_NAME.length() + 1);
        }
        String setClauseWithoutEntityAlias = setClause.replaceAll(entityAlias + "\\.", StringUtils.EMPTY);
        String[] splitChanges = setClauseWithoutEntityAlias.split(",");

        for (String change : splitChanges) {
            String[] splitChange = change.split("=");
            String entityField = splitChange[0].trim();
            String entityFieldValue = splitChange[1].trim().replaceAll("'", StringUtils.EMPTY);

            changes.put(entityField, entityFieldValue);
        }
        return changes;
    }

    public String extractEntity(String jpqlQuery) {
        return extract(jpqlQuery, UPDATE_DELETE_JPQL_OPERATION_REGEX, ENTITY_GROUP_NAME);
    }

    public String extractEntityAlias(String jpqlQuery) {
        return extract(jpqlQuery, UPDATE_DELETE_JPQL_OPERATION_REGEX, ALIAS_GROUP_NAME);
    }

    private String extract(String jpqlQuery, String regex, String groupName) {
        Matcher jpqlQueryMatcher = RegexUtil.createMatcher(regex, jpqlQuery);

        if (!jpqlQueryMatcher.find()) {
            throw new InvalidJpqlQueryException();
        }
        return jpqlQueryMatcher.group(groupName);
    }
}
