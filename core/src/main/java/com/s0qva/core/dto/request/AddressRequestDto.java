package com.s0qva.core.dto.request;

import com.s0qva.core.dto.base.BaseAttributeDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class AddressRequestDto extends BaseAttributeDto {
    private final Long subjectId;
    private final String addressTypeCode;
    private final String countryCode;
    private final String town;
    private final String street;
    private final String house;
}
