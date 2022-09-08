package com.s0qva.insurance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceCompanyReadDto {
    private Long id;
    private String taxpayerIdentificationNumber;
    private String primaryStateRegistrationNumber;
    private String fullName;
    private String address;
}
