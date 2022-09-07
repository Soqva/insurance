package com.s0qva.insurance.dto;

import java.util.Objects;

public class InsuranceCompanyFilter {
    private String taxpayerIdentificationNumber;
    private String primaryStateRegistrationNumber;
    private String fullName;
    private String address;

    public InsuranceCompanyFilter(String taxpayerIdentificationNumber,
                                  String primaryStateRegistrationNumber,
                                  String fullName,
                                  String address) {
        this.taxpayerIdentificationNumber = taxpayerIdentificationNumber;
        this.primaryStateRegistrationNumber = primaryStateRegistrationNumber;
        this.fullName = fullName;
        this.address = address;
    }

    public InsuranceCompanyFilter() {
    }

    public String getTaxpayerIdentificationNumber() {
        return taxpayerIdentificationNumber;
    }

    public void setTaxpayerIdentificationNumber(String taxpayerIdentificationNumber) {
        this.taxpayerIdentificationNumber = taxpayerIdentificationNumber;
    }

    public String getPrimaryStateRegistrationNumber() {
        return primaryStateRegistrationNumber;
    }

    public void setPrimaryStateRegistrationNumber(String primaryStateRegistrationNumber) {
        this.primaryStateRegistrationNumber = primaryStateRegistrationNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsuranceCompanyFilter that = (InsuranceCompanyFilter) o;
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
        return "InsuranceCompanyFilter{" +
                "taxpayerIdentificationNumber='" + taxpayerIdentificationNumber + '\'' +
                ", primaryStateRegistrationNumber='" + primaryStateRegistrationNumber + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
