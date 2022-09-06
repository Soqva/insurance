package com.s0qva.insurance.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "insurance_company")
public class InsuranceCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "taxpayer_identification_number")
    private String taxpayerIdentificationNumber;

    @Column(name = "primary_state_registration_number")
    private String primaryStateRegistrationNumber;

    @Column(name = "full_name")
    private String fullName;

    private String address;

    public InsuranceCompany(String taxpayerIdentificationNumber,
                            String primaryStateRegistrationNumber,
                            String fullName,
                            String address) {
        this.taxpayerIdentificationNumber = taxpayerIdentificationNumber;
        this.primaryStateRegistrationNumber = primaryStateRegistrationNumber;
        this.fullName = fullName;
        this.address = address;
    }

    public InsuranceCompany() {
    }

    public Long getId() {
        return id;
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
        InsuranceCompany that = (InsuranceCompany) o;
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
        return "InsuranceCompany{" +
                "id=" + id +
                ", taxpayerIdentificationNumber='" + taxpayerIdentificationNumber + '\'' +
                ", primaryStateRegistrationNumber='" + primaryStateRegistrationNumber + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}