package com.s0qva.core.entity;

import com.s0qva.core.entity.dictionary.AddressType;
import com.s0qva.core.entity.dictionary.Country;
import com.s0qva.core.entity.base.BaseAttributeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Audited
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "addresses")
@EqualsAndHashCode(callSuper = true)
public class Address extends BaseAttributeEntity {

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @OneToOne
    @JoinColumn(name = "address_type_code")
    private AddressType addressType;

    @OneToOne
    @JoinColumn(name = "country_code")
    private Country country;

    private String town;

    private String street;

    private String house;
}
