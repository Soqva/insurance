package com.s0qva.insurance.resolver;

import com.s0qva.insurance.repository.JpqlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class JpqlRepositoryResolver {
    private final Map<String, JpqlRepository> jpqlRepositories;

    public JpqlRepository resolve(String entityName) {
        String decapitalizedEntityName = StringUtils.uncapitalize(entityName);

        return jpqlRepositories.get(decapitalizedEntityName);
    }
}
