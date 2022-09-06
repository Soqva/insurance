package com.s0qva.insurance.dto;

import java.util.Objects;

public class InsuranceCompanyReadDto {
    private final Long id;
    private final String taxpayerIdentificationNumber;
    private final String primaryStateRegistrationNumber;
    private final String fullName;
    private final String address;

    public InsuranceCompanyReadDto(Long id,
                                   String taxpayerIdentificationNumber,
                                   String primaryStateRegistrationNumber,
                                   String fullName,
                                   String address) {
        this.id = id;
        this.taxpayerIdentificationNumber = taxpayerIdentificationNumber;
        this.primaryStateRegistrationNumber = primaryStateRegistrationNumber;
        this.fullName = fullName;
        this.address = address;
    }

    public Long getId() {
        return id;
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
        InsuranceCompanyReadDto that = (InsuranceCompanyReadDto) o;
        return Objects.equals(id, that.id)
                && Objects.equals(taxpayerIdentificationNumber, that.taxpayerIdentificationNumber)
                && Objects.equals(primaryStateRegistrationNumber, that.primaryStateRegistrationNumber)
                && Objects.equals(fullName, that.fullName)
                && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taxpayerIdentificationNumber, primaryStateRegistrationNumber, fullName, address);
    }

    @Override
    public String toString() {
        return "InsuranceCompanyReadDto{" +
                "id=" + id +
                ", taxpayerIdentificationNumber='" + taxpayerIdentificationNumber + '\'' +
                ", primaryStateRegistrationNumber='" + primaryStateRegistrationNumber + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
