package com.s0qva.insurance.service;

import com.s0qva.insurance.dto.JpqlQuery;
import com.s0qva.insurance.exception.InvalidJpqlQueryException;
import com.s0qva.insurance.resolver.JpqlRepositoryResolver;
import com.s0qva.insurance.util.JpqlOperationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class JpqlService {
    private final JpqlRepositoryResolver jpqlRepositoryResolver;

    public Object executeQuery(JpqlQuery query) {
        return Optional.ofNullable(query)
                .map(JpqlQuery::getQuery)
                .map(JpqlOperationUtil::extractEntity)
                .map(jpqlRepositoryResolver::resolve)
                .map(jpqlRepository -> jpqlRepository.executeQuery(query))
                .orElseThrow(InvalidJpqlQueryException::new);
    }
}
