package com.s0qva.core.entity.primarykey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class AttributePrimaryKey implements Serializable {

    @Column(name = "attribute_id")
    @GeneratedValue(strategy = IDENTITY)
    private Long attributeId;

    private Integer version;
}
