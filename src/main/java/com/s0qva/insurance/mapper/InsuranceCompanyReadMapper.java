package com.s0qva.insurance.mapper;

import com.s0qva.insurance.domain.InsuranceCompany;
import com.s0qva.insurance.dto.InsuranceCompanyReadDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InsuranceCompanyReadMapper {
    private final ModelMapper modelMapper;

    public InsuranceCompanyReadDto mapToDto(InsuranceCompany insuranceCompany) {
        return modelMapper.map(insuranceCompany, InsuranceCompanyReadDto.class);
    }
}
