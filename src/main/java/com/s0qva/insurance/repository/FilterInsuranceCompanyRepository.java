package com.s0qva.insurance.repository;

import com.s0qva.insurance.domain.InsuranceCompany;
import com.s0qva.insurance.dto.InsuranceCompanyFilter;

import java.util.List;

public interface FilterInsuranceCompanyRepository {

    List<InsuranceCompany> findAll(InsuranceCompanyFilter filter);
}
