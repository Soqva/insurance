package com.s0qva.insurance.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@RequiredArgsConstructor
public class InsuranceCompanyCreateEditDto {
    @NotBlank(message = "TIN must not be blank")
    @Size(min = 10, max = 10, message = "TIN must be size 10")
    private final String taxpayerIdentificationNumber;

    @NotBlank(message = "PSRN must not be blank")
    @Size(min = 13, max = 13, message = "TIN must be size 13")
    private final String primaryStateRegistrationNumber;

    @NotBlank(message = "full name must not be blank")
    @Size(max = 1024, message = "full name must be less than 1024 characters")
    private final String fullName;

    @NotBlank(message = "address must not be blank")
    @Size(max = 1024, message = "address must be less than 1024 characters")
    private final String address;
}
