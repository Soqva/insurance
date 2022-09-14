package com.s0qva.insurance.resolver;

import com.s0qva.insurance.repository.JpqlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class JpqlRepositoryResolver {
    private final Map<String, JpqlRepository> jpqlRepositories;

    public JpqlRepository resolve(String jpqlRepositoryName) {
        return jpqlRepositories.get(jpqlRepositoryName);
    }
}
