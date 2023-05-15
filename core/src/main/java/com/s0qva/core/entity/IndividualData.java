package com.s0qva.core.entity;

import com.s0qva.core.entity.base.BaseAttributeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import static javax.persistence.CascadeType.REMOVE;

@Data
@Entity
@Audited
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "individual_data")
@EqualsAndHashCode(callSuper = true)
public class IndividualData extends BaseAttributeEntity {

    @OneToOne(cascade = REMOVE)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    private String snils;

    private String inn;

    private String ogrn;
}
