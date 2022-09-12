package com.s0qva.insurance.integration.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.s0qva.insurance.dto.InsuranceCompanyCreateEditDto;
import com.s0qva.insurance.dto.InsuranceCompanyReadDto;
import com.s0qva.insurance.integration.IntegrationTestBase;
import com.s0qva.insurance.util.WebResourceLocationUtil;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@RequiredArgsConstructor
public class InsuranceCompanyRestControllerIT extends IntegrationTestBase {
    private static final String CONTROLLER_REQUEST_MAPPING = "/insurance/api/v1/insurance-companies";
    private static final String CONTROLLER_REQUEST_MAPPING_WITH_ID = "/insurance/api/v1/insurance-companies/{id}";
    private static final int AMOUNT_OF_INSURANCE_COMPANIES = 3;
    private final ObjectMapper mapper;
    private final MockMvc mvc;

    @Test
    void itShouldGetAllInsuranceCompaniesAsInsuranceCompanyReadDtoList() throws Exception {
        String content = mvc.perform(get(CONTROLLER_REQUEST_MAPPING))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse()
                .getContentAsString();
        List<InsuranceCompanyReadDto> actualOutput = mapper.readValue(content, new TypeReference<>() {
        });

        assertAll(() -> {
            assertThat(actualOutput).isNotNull();
            assertThat(actualOutput).hasSize(AMOUNT_OF_INSURANCE_COMPANIES);
        });
    }

    @Test
    void isShouldGetAllInsuranceCompaniesThatPassFilteringByEachField() throws Exception {
        String content = mvc.perform(get(CONTROLLER_REQUEST_MAPPING)
                        .param("taxpayerIdentificationNumber", "1")
                        .param("primaryStateRegistrationNumber", "111")
                        .param("fullName", "общество")
                        .param("address", "Томск")
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse()
                .getContentAsString();
        List<InsuranceCompanyReadDto> actualOutput = mapper.readValue(content, new TypeReference<>() {
        });

        assertAll(() -> {
            assertThat(actualOutput).isNotNull();
            assertThat(actualOutput).hasSize(1);
        });
    }

    @Test
    void isShouldGetAllInsuranceCompaniesThatPassFilteringByFullNameAndAddress() throws Exception {
        String content = mvc.perform(get(CONTROLLER_REQUEST_MAPPING)
                        .param("fullName", "общество")
                        .param("address", "тракт")
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse()
                .getContentAsString();
        List<InsuranceCompanyReadDto> actualOutput = mapper.readValue(content, new TypeReference<>() {
        });

        assertAll(() -> {
            assertThat(actualOutput).isNotNull();
            assertThat(actualOutput).hasSize(2);
        });
    }

    @Test
    void isShouldGetAllInsuranceCompaniesThatPassFilteringByCertainAddress() throws Exception {
        String content = mvc.perform(get(CONTROLLER_REQUEST_MAPPING)
                        .param("address", "тракт")
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse()
                .getContentAsString();
        List<InsuranceCompanyReadDto> actualOutput = mapper.readValue(content, new TypeReference<>() {
        });

        assertAll(() -> {
            assertThat(actualOutput).isNotNull();
            assertThat(actualOutput).hasSize(2);
        });
    }

    @Test
    void isShouldGetAllInsuranceCompaniesThatPassFilteringByCertainFullName() throws Exception {
        String content = mvc.perform(get(CONTROLLER_REQUEST_MAPPING)
                        .param("fullName", "new")
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse()
                .getContentAsString();
        List<InsuranceCompanyReadDto> actualOutput = mapper.readValue(content, new TypeReference<>() {
        });

        assertAll(() -> {
            assertThat(actualOutput).isNotNull();
            assertThat(actualOutput).hasSize(1);
        });
    }

    @Test
    void isShouldGetAllInsuranceCompaniesThatPassFilteringByCertainPSRN() throws Exception {
        String content = mvc.perform(get(CONTROLLER_REQUEST_MAPPING)
                        .param("primaryStateRegistrationNumber", "333")
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse()
                .getContentAsString();
        List<InsuranceCompanyReadDto> actualOutput = mapper.readValue(content, new TypeReference<>() {
        });

        assertAll(() -> {
            assertThat(actualOutput).isNotNull();
            assertThat(actualOutput).hasSize(1);
        });
    }

    @Test
    void isShouldGetAllInsuranceCompaniesThatPassFilteringByCertainTIN() throws Exception {
        String content = mvc.perform(get(CONTROLLER_REQUEST_MAPPING)
                        .param("taxpayerIdentificationNumber", "1111111111")
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse()
                .getContentAsString();
        List<InsuranceCompanyReadDto> actualOutput = mapper.readValue(content, new TypeReference<>() {
        });

        assertAll(() -> {
            assertThat(actualOutput).isNotNull();
            assertThat(actualOutput).hasSize(1);
        });
    }

    @Test
    void itShouldGetInsuranceCompanyByItsId() throws Exception {
        Long insuranceCompanyId = 1L;
        String content = mvc.perform(get(CONTROLLER_REQUEST_MAPPING_WITH_ID, insuranceCompanyId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse()
                .getContentAsString();
        InsuranceCompanyReadDto actualOutput = mapper.readValue(content, new TypeReference<>() {
        });

        assertAll(() -> {
            assertThat(actualOutput).isNotNull();
            assertThat(actualOutput.getId()).isNotNull();
            assertThat(actualOutput.getId()).isEqualTo(insuranceCompanyId);
            assertThat(actualOutput.getTaxpayerIdentificationNumber()).isEqualTo("1111111111");
        });
    }

    @Test
    void itShouldCreateInsuranceCompanyAndGetCreatedInsuranceCompanyLocation() throws Exception {
        Long createdInsuranceCompanyId = 4L;
        InsuranceCompanyCreateEditDto insuranceCompanyDto = InsuranceCompanyCreateEditDto.builder()
                .taxpayerIdentificationNumber("1000000000")
                .primaryStateRegistrationNumber("1000000000000")
                .fullName("new insurance company")
                .address("new address")
                .build();
        String expectedLocation = WebResourceLocationUtil.buildWebResourceLocation(
                CONTROLLER_REQUEST_MAPPING_WITH_ID,
                createdInsuranceCompanyId
        ).toString();
        String actualOutput = mvc.perform(post(CONTROLLER_REQUEST_MAPPING)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(insuranceCompanyDto))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getHeader("Location");

        assertAll(() -> {
            assertThat(actualOutput).isNotNull();
            assertThat(actualOutput).isEqualTo(expectedLocation);
        });
    }
}
