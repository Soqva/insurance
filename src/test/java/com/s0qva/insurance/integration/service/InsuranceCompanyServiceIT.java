package com.s0qva.insurance.integration.service;

import com.s0qva.insurance.dto.InsuranceCompanyCreateEditDto;
import com.s0qva.insurance.dto.InsuranceCompanyFilter;
import com.s0qva.insurance.dto.InsuranceCompanyReadDto;
import com.s0qva.insurance.integration.IntegrationTestBase;
import com.s0qva.insurance.service.InsuranceCompanyService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@RequiredArgsConstructor
public class InsuranceCompanyServiceIT extends IntegrationTestBase {
    private static final Long EXAMPLE_TEST_INSURANCE_COMPANY_ID = 1L;
    private static final int AMOUNT_OF_INSURANCE_COMPANIES = 3;
    private final InsuranceCompanyService underTest;

    @Test
    void isShouldGetAllExistingInsuranceCompaniesAsInsuranceCompanyReadDtoList() {
        InsuranceCompanyFilter emptyFilter = InsuranceCompanyFilter.builder().build();
        List<InsuranceCompanyReadDto> actualOutput = underTest.getAll(emptyFilter);

        assertAll(() -> {
           assertThat(actualOutput).isNotNull();
           assertThat(actualOutput.size()).isEqualTo(AMOUNT_OF_INSURANCE_COMPANIES);
        });
    }

    @Test
    void itShouldGetExistingInsuranceCompanyByItsIdAsInsuranceCompanyReadDto() {
        InsuranceCompanyReadDto actualOutput = underTest.getById(EXAMPLE_TEST_INSURANCE_COMPANY_ID);

        assertAll(() -> {
            assertThat(actualOutput).isNotNull();
            assertThat(actualOutput.getId()).isEqualTo(EXAMPLE_TEST_INSURANCE_COMPANY_ID);
        });
    }

    @Test
    void itShouldCreateInsuranceCompanyAccordingToInsuranceCompanyCreateEditDto() {
        InsuranceCompanyCreateEditDto insuranceCompanyDto = new InsuranceCompanyCreateEditDto(
                "111",
                "111",
                "Example full name",
                "Example address"
        );
        InsuranceCompanyReadDto actualOutput = underTest.create(insuranceCompanyDto);

        assertAll(() -> {
            assertThat(actualOutput).isNotNull();
            assertThat(actualOutput.getId()).isNotNull();
            assertThat(actualOutput.getTaxpayerIdentificationNumber()).isEqualTo(insuranceCompanyDto.getTaxpayerIdentificationNumber());
            assertThat(actualOutput.getPrimaryStateRegistrationNumber()).isEqualTo(insuranceCompanyDto.getPrimaryStateRegistrationNumber());
            assertThat(actualOutput.getFullName()).isEqualTo(insuranceCompanyDto.getFullName());
            assertThat(actualOutput.getAddress()).isEqualTo(insuranceCompanyDto.getAddress());
        });
    }
}
