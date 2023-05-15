package com.s0qva.core.dto.response;

import com.s0qva.core.dto.base.BaseAttributeDto;
import com.s0qva.core.dto.response.dictionary.AddressTypeResponseDto;
import com.s0qva.core.dto.response.dictionary.CountryResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class AddressResponseDto extends BaseAttributeDto {
    private final AddressTypeResponseDto addressTypeResponseDto;
    private final CountryResponseDto countryResponseDto;
    private final String town;
    private final String street;
    private final String house;
}
