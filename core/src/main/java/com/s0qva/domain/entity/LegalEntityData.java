package com.s0qva.domain.entity;

import com.s0qva.domain.entity.base.BaseAttributeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "legal_entity_data")
@EqualsAndHashCode(callSuper = true)
public class LegalEntityData extends BaseAttributeEntity {

    @OneToOne(cascade = REMOVE)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "short_name")
    private String shortName;

    private String inn;

    private String ogrn;
}
