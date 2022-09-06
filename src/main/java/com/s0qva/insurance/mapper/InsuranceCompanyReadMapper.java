package com.s0qva.insurance.mapper;

import com.s0qva.insurance.domain.InsuranceCompany;
import com.s0qva.insurance.dto.InsuranceCompanyReadDto;
import org.springframework.stereotype.Component;

@Component
public class InsuranceCompanyReadMapper {

    public InsuranceCompanyReadDto mapToDto(InsuranceCompany insuranceCompany) {
        return new InsuranceCompanyReadDto(
                insuranceCompany.getId(),
                insuranceCompany.getTaxpayerIdentificationNumber(),
                insuranceCompany.getPrimaryStateRegistrationNumber(),
                insuranceCompany.getFullName(),
                insuranceCompany.getAddress()
        );
    }
}
