package com.s0qva.insurance.integration.mapper;

import com.s0qva.insurance.domain.InsuranceCompany;
import com.s0qva.insurance.dto.InsuranceCompanyCreateEditDto;
import com.s0qva.insurance.integration.IntegrationTestBase;
import com.s0qva.insurance.mapper.InsuranceCompanyCreateEditMapper;
import com.s0qva.insurance.repository.InsuranceCompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class InsuranceCompanyCreateEditMapperIT extends IntegrationTestBase {
    private static final Long EXAMPLE_TEST_INSURANCE_COMPANY_ID = 1L;
    private static final InsuranceCompanyCreateEditDto DEFAULT_TEST_DTO = new InsuranceCompanyCreateEditDto(
            "111",
            "111",
            "Example full name",
            "Example address"
    );
    private final InsuranceCompanyCreateEditMapper underTest;
    private final InsuranceCompanyRepository insuranceCompanyRepository;

    @Autowired
    public InsuranceCompanyCreateEditMapperIT(InsuranceCompanyCreateEditMapper underTest,
                                              InsuranceCompanyRepository insuranceCompanyRepository) {
        this.underTest = underTest;
        this.insuranceCompanyRepository = insuranceCompanyRepository;
    }

    @Test
    void itShouldMapInsuranceCompanyCreateEditDtoToInsuranceCompany() {
        InsuranceCompanyCreateEditDto insuranceCompanyDto = DEFAULT_TEST_DTO;
        InsuranceCompany actualOutput = underTest.mapToEntity(insuranceCompanyDto);

        assertAll(() -> {
            assertThat(actualOutput).isNotNull();
            assertThat(actualOutput.getId()).isNull();
            assertThat(actualOutput.getTaxpayerIdentificationNumber()).isEqualTo(insuranceCompanyDto.getTaxpayerIdentificationNumber());
            assertThat(actualOutput.getPrimaryStateRegistrationNumber()).isEqualTo(insuranceCompanyDto.getPrimaryStateRegistrationNumber());
            assertThat(actualOutput.getFullName()).isEqualTo(insuranceCompanyDto.getFullName());
            assertThat(actualOutput.getAddress()).isEqualTo(insuranceCompanyDto.getAddress());
        });
    }

    @Test
    void isShouldEditExistingInsuranceCompanyAccordingToReceivedDto() {
        InsuranceCompany insuranceCompany = insuranceCompanyRepository.findById(EXAMPLE_TEST_INSURANCE_COMPANY_ID)
                .orElseGet(InsuranceCompany::new);
        InsuranceCompanyCreateEditDto insuranceCompanyDto = DEFAULT_TEST_DTO;
        InsuranceCompany actualOutput = underTest.editEntity(insuranceCompany, insuranceCompanyDto);

        assertAll(() -> {
            assertThat(actualOutput).isNotNull();
            assertThat(actualOutput.getId()).isEqualTo(EXAMPLE_TEST_INSURANCE_COMPANY_ID);
            assertThat(actualOutput.getTaxpayerIdentificationNumber()).isEqualTo(insuranceCompanyDto.getTaxpayerIdentificationNumber());
            assertThat(actualOutput.getPrimaryStateRegistrationNumber()).isEqualTo(insuranceCompanyDto.getPrimaryStateRegistrationNumber());
            assertThat(actualOutput.getFullName()).isEqualTo(insuranceCompanyDto.getFullName());
            assertThat(actualOutput.getAddress()).isEqualTo(insuranceCompanyDto.getAddress());
        });
    }
}
