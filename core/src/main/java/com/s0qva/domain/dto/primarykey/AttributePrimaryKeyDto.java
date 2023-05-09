package com.s0qva.domain.dto.primarykey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttributePrimaryKeyDto {
    private Long attributeId;
    private Integer version;
}
