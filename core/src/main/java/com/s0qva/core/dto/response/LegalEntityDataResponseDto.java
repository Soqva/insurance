package com.s0qva.core.dto.response;

import com.s0qva.core.dto.base.BaseAttributeDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class LegalEntityDataResponseDto extends BaseAttributeDto {
    private final String fullName;
    private final String shortName;
    private final String inn;
    private final String ogrn;
}
