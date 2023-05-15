package com.s0qva.core.dto.base;

import com.s0qva.core.dto.primarykey.AttributePrimaryKeyDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class BaseAttributeDto {
    private final AttributePrimaryKeyDto attributePrimaryKeyDto;
    private final Long effectiveDate;
    private final Long entryDate;
}
