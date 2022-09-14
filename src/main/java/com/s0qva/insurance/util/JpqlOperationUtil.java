package com.s0qva.insurance.util;

import liquibase.repackaged.org.apache.commons.lang3.StringUtils;
import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UtilityClass
public class JpqlOperationUtil {
    private static final String UPDATE_DELETE_JPQL_OPERATION_REGEX = "(update|delete from)";
    private static final String UPDATE_SET_WITH_WHERE_REGEX = "(set.+).*where";
    private static final String UPDATE_SET_REGEX = "(set.+)";
    private static final String UPDATE_SET_ALIAS_REGEX = ".*\\.";
    private static final Map<String, String> REGULAR_EXPRESSIONS_WITH_REPLACEMENT = Map.of(
            UPDATE_DELETE_JPQL_OPERATION_REGEX, "select i from",
            UPDATE_SET_WITH_WHERE_REGEX, StringUtils.EMPTY,
            UPDATE_SET_REGEX, StringUtils.EMPTY
    );

    public String convertToSelectJpqlQuery(String jpqlQuery) {
        String selectJpqlQuery = jpqlQuery;

        for (Map.Entry<String, String> regexWithReplacement : REGULAR_EXPRESSIONS_WITH_REPLACEMENT.entrySet()) {
            String regex = regexWithReplacement.getKey();
            String replacement = regexWithReplacement.getValue();

            if (regex.contains("set") && !regex.contains("where") && selectJpqlQuery.contains("where")) {
                continue;
            }
            Pattern compiledRegexPattern = Pattern.compile(regex);
            Matcher matcher = compiledRegexPattern.matcher(selectJpqlQuery);

            while (matcher.find()) {
                String targetToReplace = matcher.group(1);
                selectJpqlQuery = selectJpqlQuery.replace(targetToReplace, replacement);
            }
        }
        return selectJpqlQuery;
    }

    public Map<String, String> extractChanges(String jpqlQuery) {
        Map<String, String> changes = new HashMap<>();
        Pattern compiledRegexPattern;

        if (jpqlQuery.contains("where")) {
            compiledRegexPattern = Pattern.compile(UPDATE_SET_WITH_WHERE_REGEX);
        } else {
            compiledRegexPattern = Pattern.compile(UPDATE_SET_REGEX);
        }
        Matcher matcher = compiledRegexPattern.matcher(jpqlQuery);

        while (matcher.find()) {
            String changesGroup = matcher.group(1);
            String[] splitChangesGroup = changesGroup.split(",");

            for (String unformattedChange : splitChangesGroup) {
                String formattedChange = unformattedChange.replaceFirst(UPDATE_SET_ALIAS_REGEX, StringUtils.EMPTY);
                String[] splitFormattedChange = formattedChange.trim().split("=");
                String entityField = splitFormattedChange[0];
                String entityFieldValue = splitFormattedChange[1].replace("'", StringUtils.EMPTY);

                changes.put(entityField, entityFieldValue);
            }
        }
        return changes;
    }
}
