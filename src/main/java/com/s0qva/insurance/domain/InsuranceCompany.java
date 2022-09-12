package com.s0qva.insurance.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`INSURANCE_COMPANY`")
@Audited
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`")
    private Long id;

    @Column(name = "`TAXPAYER_IDENTIFICATION_NUMBER`")
    private String taxpayerIdentificationNumber;

    @Column(name = "`PRIMARY_STATE_REGISTRATION_NUMBER`")
    private String primaryStateRegistrationNumber;

    @Column(name = "`FULL_NAME`")
    private String fullName;

    @Column(name = "`ADDRESS`")
    private String address;
}
