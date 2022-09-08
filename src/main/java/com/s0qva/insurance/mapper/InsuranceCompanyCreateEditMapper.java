package com.s0qva.insurance.mapper;

import com.s0qva.insurance.domain.InsuranceCompany;
import com.s0qva.insurance.dto.InsuranceCompanyCreateEditDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InsuranceCompanyCreateEditMapper {
    private final ModelMapper modelMapper;

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
        modelMapper.map(insuranceCompanyDto, insuranceCompany);
    }
}
