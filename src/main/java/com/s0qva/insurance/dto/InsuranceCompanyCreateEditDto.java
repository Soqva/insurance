package com.s0qva.insurance.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class InsuranceCompanyCreateEditDto {
    private final String taxpayerIdentificationNumber;
    private final String primaryStateRegistrationNumber;
    private final String fullName;
    private final String address;
}
