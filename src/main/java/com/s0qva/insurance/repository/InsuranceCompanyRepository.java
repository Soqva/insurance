package com.s0qva.insurance.repository;

import com.s0qva.insurance.domain.InsuranceCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceCompanyRepository extends JpaRepository<InsuranceCompany, Long>, FilterInsuranceCompanyRepository {
}
