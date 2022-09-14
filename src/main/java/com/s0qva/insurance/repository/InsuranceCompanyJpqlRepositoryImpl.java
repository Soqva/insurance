package com.s0qva.insurance.repository;

import com.s0qva.insurance.dto.JpqlQuery;
import com.s0qva.insurance.jqpl.operation.JpqlOperation;
import com.s0qva.insurance.resolver.JpqlOperationResolver;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InsuranceCompanyJpqlRepositoryImpl implements InsuranceCompanyJpqlRepository {
    private final JpqlOperationResolver jpqlOperationResolver;

    @Override
    public Object executeQuery(JpqlQuery query) {
        String jpqlOperationName = query.getOperationName();
        JpqlOperation<?> jpqlOperation = jpqlOperationResolver.resolve(jpqlOperationName);

        return jpqlOperation.executeQuery(query);
    }
}
