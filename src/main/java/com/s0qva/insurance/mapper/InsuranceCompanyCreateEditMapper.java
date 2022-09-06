package com.s0qva.insurance.mapper;

import com.s0qva.insurance.domain.InsuranceCompany;
import com.s0qva.insurance.dto.InsuranceCompanyCreateEditDto;
import org.springframework.stereotype.Component;

@Component
public class InsuranceCompanyCreateEditMapper {

    public InsuranceCompany mapToEntity(InsuranceCompanyCreateEditDto insuranceCompanyDto) {
        InsuranceCompany insuranceCompany = new InsuranceCompany();

        edit(insuranceCompany, insuranceCompanyDto);
        return insuranceCompany;
    }

    public InsuranceCompany editEntity(InsuranceCompany insuranceCompany,
                                       InsuranceCompanyCreateEditDto insuranceCompanyDto) {
        edit(insuranceCompany, insuranceCompanyDto);
        return insuranceCompany;
    }

    private void edit(InsuranceCompany insuranceCompany, InsuranceCompanyCreateEditDto insuranceCompanyDto) {
        insuranceCompany.setTaxpayerIdentificationNumber(insuranceCompanyDto.getTaxpayerIdentificationNumber());
        insuranceCompany.setPrimaryStateRegistrationNumber(insuranceCompanyDto.getPrimaryStateRegistrationNumber());
        insuranceCompany.setFullName(insuranceCompanyDto.getFullName());
        insuranceCompany.setAddress(insuranceCompanyDto.getAddress());
    }
}
