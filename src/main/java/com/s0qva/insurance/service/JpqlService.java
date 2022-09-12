package com.s0qva.insurance.service;

import com.s0qva.insurance.resolver.JpqlOperationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class JpqlService {
    private final JpqlOperationResolver jpqlOperationResolver;

    public Object executeQuery(String query) {
        return Optional.ofNullable(query)
                .map(jpqlOperationResolver::resolve)
                .map(jpqlOperation -> jpqlOperation.execute(query))
                .orElseThrow(() -> new RuntimeException("Failed to execute the query"));
    }
}
