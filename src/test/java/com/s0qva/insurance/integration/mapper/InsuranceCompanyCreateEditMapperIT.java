package com.s0qva.insurance.integration.mapper;

import com.s0qva.insurance.domain.InsuranceCompany;
import com.s0qva.insurance.dto.InsuranceCompanyCreateEditDto;
import com.s0qva.insurance.integration.IntegrationTestBase;
import com.s0qva.insurance.mapper.InsuranceCompanyCreateEditMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@RequiredArgsConstructor
public class InsuranceCompanyCreateEditMapperIT extends IntegrationTestBase {
    private static final InsuranceCompany DEFAULT_TEST_INSURANCE_COMPANY = InsuranceCompany.builder()
            .id(1L)
            .taxpayerIdentificationNumber("111")
            .primaryStateRegistrationNumber("222")
            .fullName("Example Corporation")
            .address("Example Corporation Address")
            .build();
    private static final InsuranceCompanyCreateEditDto DEFAULT_TEST_DTO = InsuranceCompanyCreateEditDto.builder()
            .taxpayerIdentificationNumber("1110111")
            .primaryStateRegistrationNumber("2220222")
            .fullName("Custom Corporation full name")
            .address("Custom Corporation address")
            .build();
    private final InsuranceCompanyCreateEditMapper underTest;

    @Test
    void itShouldMapInsuranceCompanyCreateEditDtoToInsuranceCompany() {
        InsuranceCompany actualOutput = underTest.mapToEntity(DEFAULT_TEST_DTO);

        assertAll(() -> {
            assertThat(actualOutput).isNotNull();
            assertThat(actualOutput.getId()).isNull();
            assertThat(actualOutput.getTaxpayerIdentificationNumber()).isEqualTo(DEFAULT_TEST_DTO.getTaxpayerIdentificationNumber());
            assertThat(actualOutput.getPrimaryStateRegistrationNumber()).isEqualTo(DEFAULT_TEST_DTO.getPrimaryStateRegistrationNumber());
            assertThat(actualOutput.getFullName()).isEqualTo(DEFAULT_TEST_DTO.getFullName());
            assertThat(actualOutput.getAddress()).isEqualTo(DEFAULT_TEST_DTO.getAddress());
        });
    }

    @Test
    void isShouldEditExistingInsuranceCompanyAccordingToReceivedDto() {
        InsuranceCompany actualOutput = underTest.editEntity(DEFAULT_TEST_INSURANCE_COMPANY, DEFAULT_TEST_DTO);

        assertAll(() -> {
            assertThat(actualOutput).isNotNull();
            assertThat(actualOutput.getId()).isEqualTo(DEFAULT_TEST_INSURANCE_COMPANY.getId());
            assertThat(actualOutput.getTaxpayerIdentificationNumber()).isEqualTo(DEFAULT_TEST_DTO.getTaxpayerIdentificationNumber());
            assertThat(actualOutput.getPrimaryStateRegistrationNumber()).isEqualTo(DEFAULT_TEST_DTO.getPrimaryStateRegistrationNumber());
            assertThat(actualOutput.getFullName()).isEqualTo(DEFAULT_TEST_DTO.getFullName());
            assertThat(actualOutput.getAddress()).isEqualTo(DEFAULT_TEST_DTO.getAddress());
        });
    }
}
