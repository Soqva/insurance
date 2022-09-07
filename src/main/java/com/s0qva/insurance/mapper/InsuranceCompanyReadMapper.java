package com.s0qva.insurance.mapper;

import com.s0qva.insurance.domain.InsuranceCompany;
import com.s0qva.insurance.dto.InsuranceCompanyReadDto;
import org.springframework.stereotype.Component;

@Component
public class InsuranceCompanyReadMapper {

    public InsuranceCompanyReadDto mapToDto(InsuranceCompany insuranceCompany) {
        return InsuranceCompanyReadDto.builder()
                .id(insuranceCompany.getId())
                .taxpayerIdentificationNumber(insuranceCompany.getTaxpayerIdentificationNumber())
                .primaryStateRegistrationNumber(insuranceCompany.getPrimaryStateRegistrationNumber())
                .fullName(insuranceCompany.getFullName())
                .address(insuranceCompany.getAddress())
                .build();
    }
}
