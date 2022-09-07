package com.s0qva.insurance.util;

import com.s0qva.insurance.domain.InsuranceCompany;
import com.s0qva.insurance.dto.InsuranceCompanyFilter;
import lombok.experimental.UtilityClass;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@UtilityClass
public class InsuranceCompanyCriteriaBuilder {

    public CriteriaQuery<InsuranceCompany> buildQueryByInsuranceCompanyFilter(CriteriaBuilder builder, InsuranceCompanyFilter filter) {
        CriteriaQuery<InsuranceCompany> query = builder.createQuery(InsuranceCompany.class);
        Root<InsuranceCompany> insuranceCompany = query.from(InsuranceCompany.class);
        List<Predicate> predicates = new ArrayList<>();

        if (!Objects.isNull(filter.getTaxpayerIdentificationNumber())) {
            predicates.add(builder.like(
                    builder.lower(insuranceCompany.get("taxpayerIdentificationNumber")),
                    CriteriaQueryUtil.formatAsPatternMatching(filter.getTaxpayerIdentificationNumber().toLowerCase())
            ));
        }
        if (!Objects.isNull(filter.getPrimaryStateRegistrationNumber())) {
            predicates.add(builder.like(
                    builder.lower(insuranceCompany.get("primaryStateRegistrationNumber")),
                    CriteriaQueryUtil.formatAsPatternMatching(filter.getPrimaryStateRegistrationNumber().toLowerCase())
            ));
        }
        if (!Objects.isNull(filter.getFullName())) {
            predicates.add(builder.like(
                    builder.lower(insuranceCompany.get("fullName")),
                    CriteriaQueryUtil.formatAsPatternMatching(filter.getFullName().toLowerCase())
            ));
        }
        if (!Objects.isNull(filter.getAddress())) {
            predicates.add(builder.like(
                    builder.lower(insuranceCompany.get("address")),
                    CriteriaQueryUtil.formatAsPatternMatching(filter.getAddress().toLowerCase())
            ));
        }
        return query.select(insuranceCompany).where(predicates.toArray(Predicate[]::new));
    }
}
