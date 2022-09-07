package com.s0qva.insurance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class InsuranceCompanyFilter {
    private final String taxpayerIdentificationNumber;
    private final String primaryStateRegistrationNumber;
    private final String fullName;
    private final String address;
}
