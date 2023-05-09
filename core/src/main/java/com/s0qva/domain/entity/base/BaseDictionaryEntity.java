package com.s0qva.domain.entity.base;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseDictionaryEntity {

    @Id
    private String code;

    private String description;
}
