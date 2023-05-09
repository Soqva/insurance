package com.s0qva.domain.entity.base;

import com.s0qva.domain.entity.primarykey.AttributePrimaryKey;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseAttributeEntity {

    @EmbeddedId
    private AttributePrimaryKey id;

    @Column(name = "effective_date")
    private LocalDate effectiveDate;

    @Column(name = "entry_date")
    private LocalDateTime entryDate;
}
