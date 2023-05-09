package com.s0qva.domain.dto.base;

import com.s0qva.domain.dto.primarykey.AttributePrimaryKeyDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseAttributeDto {
    private AttributePrimaryKeyDto attributePrimaryKeyDto;
    private Long effectiveDate;
    private Long entryDate;
}
