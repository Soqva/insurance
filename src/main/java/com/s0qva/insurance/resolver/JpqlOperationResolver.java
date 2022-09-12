package com.s0qva.insurance.resolver;

import com.s0qva.insurance.jqpl.operation.JpqlOperation;
import liquibase.repackaged.org.apache.commons.lang3.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class JpqlOperationResolver {
    private final Map<String, JpqlOperation<?>> jpqlOperations;

    public JpqlOperation<?> resolve(String query) {
        if (StringUtils.isBlank(query)) {
            throw new RuntimeException("Query is blank");
        }
        String operationName = StringUtils.substringBefore(query, StringUtils.SPACE);
        String caseInsensitiveOperationName = operationName.toLowerCase();

        return jpqlOperations.get(caseInsensitiveOperationName);
    }
}
