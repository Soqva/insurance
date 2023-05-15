package com.s0qva.core.dto.response;

import com.s0qva.core.dto.base.BaseAttributeDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class IndividualDataResponseDto extends BaseAttributeDto {
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final String snils;
    private final String inn;
    private final String ogrn;
}
