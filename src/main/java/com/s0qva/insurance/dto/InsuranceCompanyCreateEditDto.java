package com.s0qva.insurance.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Objects;

public class InsuranceCompanyCreateEditDto {
    private final String taxpayerIdentificationNumber;
    private final String primaryStateRegistrationNumber;
    private final String fullName;
    private final String address;

    @JsonCreator
    public InsuranceCompanyCreateEditDto(String taxpayerIdentificationNumber,
                                         String primaryStateRegistrationNumber,
                                         String fullName,
                                         String address) {
        this.taxpayerIdentificationNumber = taxpayerIdentificationNumber;
        this.primaryStateRegistrationNumber = primaryStateRegistrationNumber;
        this.fullName = fullName;
        this.address = address;
    }

    public String getTaxpayerIdentificationNumber() {
        return taxpayerIdentificationNumber;
    }

    public String getPrimaryStateRegistrationNumber() {
        return primaryStateRegistrationNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsuranceCompanyCreateEditDto that = (InsuranceCompanyCreateEditDto) o;
        return Objects.equals(taxpayerIdentificationNumber, that.taxpayerIdentificationNumber)
                && Objects.equals(primaryStateRegistrationNumber, that.primaryStateRegistrationNumber)
                && Objects.equals(fullName, that.fullName)
                && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taxpayerIdentificationNumber, primaryStateRegistrationNumber, fullName, address);
    }

    @Override
    public String toString() {
        return "InsuranceCompanyCreateEditDto{" +
                "taxpayerIdentificationNumber='" + taxpayerIdentificationNumber + '\'' +
                ", primaryStateRegistrationNumber='" + primaryStateRegistrationNumber + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
