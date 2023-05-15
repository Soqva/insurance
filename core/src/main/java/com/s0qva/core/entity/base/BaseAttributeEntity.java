package com.s0qva.core.entity.base;

import com.s0qva.core.entity.primarykey.AttributePrimaryKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class BaseAttributeEntity {

    @EmbeddedId
    private AttributePrimaryKey id;

    @Column(name = "effective_date")
    private LocalDate effectiveDate;

    @Column(name = "entry_date")
    private LocalDateTime entryDate;
}
