package com.s0qva.domain.entity.primarykey;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Embeddable
public class AttributePrimaryKey implements Serializable {

    @Column(name = "attribute_id")
    @GeneratedValue(strategy = IDENTITY)
    private Long attributeId;

    private Integer version;
}
