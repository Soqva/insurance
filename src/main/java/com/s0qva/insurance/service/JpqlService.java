package com.s0qva.insurance.service;

import com.s0qva.insurance.dto.JpqlQuery;
import com.s0qva.insurance.repository.JpqlRepository;
import com.s0qva.insurance.resolver.JpqlRepositoryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class JpqlService {
    private final JpqlRepositoryResolver jpqlRepositoryResolver;

    public Object executeQuery(JpqlQuery query) {
        String jpqlRepositoryName = query.getRepositoryName();
        JpqlRepository repository = jpqlRepositoryResolver.resolve(jpqlRepositoryName);

        return repository.executeQuery(query);
    }
}
