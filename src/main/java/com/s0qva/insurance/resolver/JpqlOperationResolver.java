package com.s0qva.insurance.resolver;

import com.s0qva.insurance.jqpl.operation.JpqlOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class JpqlOperationResolver {
    private final Map<String, JpqlOperation<?>> jpqlOperations;

    public JpqlOperation<?> resolve(String jpqlOperationName) {
        String caseInsensitiveOperationName = jpqlOperationName.toLowerCase();

        return jpqlOperations.get(caseInsensitiveOperationName);
    }
}
