package com.s0qva.core.dto.primarykey;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class AttributePrimaryKeyDto {
    private final Long attributeId;
    private final Integer version;
}
