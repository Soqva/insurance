package com.s0qva.insurance.integration.mapper;

import com.s0qva.insurance.domain.InsuranceCompany;
import com.s0qva.insurance.dto.InsuranceCompanyReadDto;
import com.s0qva.insurance.integration.IntegrationTestBase;
import com.s0qva.insurance.mapper.InsuranceCompanyReadMapper;
import com.s0qva.insurance.repository.InsuranceCompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class InsuranceCompanyReadMapperIT extends IntegrationTestBase {
    private static final Long EXAMPLE_TEST_INSURANCE_COMPANY_ID = 1L;
    private final InsuranceCompanyReadMapper underTest;
    private final InsuranceCompanyRepository insuranceCompanyRepository;

    @Autowired
    public InsuranceCompanyReadMapperIT(InsuranceCompanyReadMapper underTest,
                                        InsuranceCompanyRepository insuranceCompanyRepository) {
        this.underTest = underTest;
        this.insuranceCompanyRepository = insuranceCompanyRepository;
    }

    @Test
    void itShouldMapInsuranceCompanyToInsuranceCompanyReadDto() {
        InsuranceCompany insuranceCompany = insuranceCompanyRepository.findById(EXAMPLE_TEST_INSURANCE_COMPANY_ID)
                .orElseGet(InsuranceCompany::new);
        InsuranceCompanyReadDto actualOutput = underTest.mapToDto(insuranceCompany);

        assertAll(() -> {
            assertThat(actualOutput.getId()).isEqualTo(EXAMPLE_TEST_INSURANCE_COMPANY_ID);
            assertThat(actualOutput.getTaxpayerIdentificationNumber()).isEqualTo(insuranceCompany.getTaxpayerIdentificationNumber());
            assertThat(actualOutput.getPrimaryStateRegistrationNumber()).isEqualTo(insuranceCompany.getPrimaryStateRegistrationNumber());
            assertThat(actualOutput.getFullName()).isEqualTo(insuranceCompany.getFullName());
            assertThat(actualOutput.getAddress()).isEqualTo(insuranceCompany.getAddress());
        });
    }
}
