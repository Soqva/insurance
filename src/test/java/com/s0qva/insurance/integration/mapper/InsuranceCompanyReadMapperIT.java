package com.s0qva.insurance.integration.mapper;

import com.s0qva.insurance.domain.InsuranceCompany;
import com.s0qva.insurance.dto.InsuranceCompanyReadDto;
import com.s0qva.insurance.integration.IntegrationTestBase;
import com.s0qva.insurance.mapper.InsuranceCompanyReadMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@RequiredArgsConstructor
public class InsuranceCompanyReadMapperIT extends IntegrationTestBase {
    private static final InsuranceCompany DEFAULT_TEST_INSURANCE_COMPANY = InsuranceCompany.builder()
            .id(1L)
            .taxpayerIdentificationNumber("111")
            .primaryStateRegistrationNumber("222")
            .fullName("Example Corporation")
            .address("Example Corporation Address")
            .build();
    private final InsuranceCompanyReadMapper underTest;

    @Test
    void itShouldMapInsuranceCompanyToInsuranceCompanyReadDto() {
        InsuranceCompanyReadDto actualOutput = underTest.mapToDto(DEFAULT_TEST_INSURANCE_COMPANY);

        assertAll(() -> {
            assertThat(actualOutput.getId()).isEqualTo(DEFAULT_TEST_INSURANCE_COMPANY.getId());
            assertThat(actualOutput.getTaxpayerIdentificationNumber()).isEqualTo(DEFAULT_TEST_INSURANCE_COMPANY.getTaxpayerIdentificationNumber());
            assertThat(actualOutput.getPrimaryStateRegistrationNumber()).isEqualTo(DEFAULT_TEST_INSURANCE_COMPANY.getPrimaryStateRegistrationNumber());
            assertThat(actualOutput.getFullName()).isEqualTo(DEFAULT_TEST_INSURANCE_COMPANY.getFullName());
            assertThat(actualOutput.getAddress()).isEqualTo(DEFAULT_TEST_INSURANCE_COMPANY.getAddress());
        });
    }
}
