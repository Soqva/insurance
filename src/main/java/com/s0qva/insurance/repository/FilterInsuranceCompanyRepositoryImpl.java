package com.s0qva.insurance.repository;

import com.s0qva.insurance.domain.InsuranceCompany;
import com.s0qva.insurance.dto.InsuranceCompanyFilter;
import com.s0qva.insurance.util.InsuranceCompanyCriteriaBuilder;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class FilterInsuranceCompanyRepositoryImpl implements FilterInsuranceCompanyRepository {
    private final EntityManager entityManager;

    public FilterInsuranceCompanyRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<InsuranceCompany> findAll(InsuranceCompanyFilter filter) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<InsuranceCompany> query = InsuranceCompanyCriteriaBuilder.buildQueryByInsuranceCompanyFilter(builder, filter);

        return entityManager.createQuery(query).getResultList();
    }
}
