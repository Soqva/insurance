package com.s0qva.insurance.integration.service;

import com.s0qva.insurance.dto.InsuranceCompanyCreateEditDto;
import com.s0qva.insurance.dto.InsuranceCompanyFilter;
import com.s0qva.insurance.dto.InsuranceCompanyReadDto;
import com.s0qva.insurance.integration.IntegrationTestBase;
import com.s0qva.insurance.service.InsuranceCompanyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class InsuranceCompanyServiceIT extends IntegrationTestBase {
    private static final Long EXAMPLE_TEST_INSURANCE_COMPANY_ID = 1L;
    private static final int AMOUNT_OF_INSURANCE_COMPANIES = 3;
    private final InsuranceCompanyService underTest;

    @Autowired
    public InsuranceCompanyServiceIT(InsuranceCompanyService underTest) {
        this.underTest = underTest;
    }

    @Test
    void isShouldGetAllExistingInsuranceCompaniesAsInsuranceCompanyReadDtoList() {
        List<InsuranceCompanyReadDto> actualOutput = underTest.getAll(new InsuranceCompanyFilter());

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
