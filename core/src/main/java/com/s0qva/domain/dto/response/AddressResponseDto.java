package com.s0qva.domain.dto.response;

import com.s0qva.domain.dto.base.BaseAttributeDto;
import com.s0qva.domain.dto.response.dictionary.AddressTypeResponseDto;
import com.s0qva.domain.dto.response.dictionary.CountryResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AddressResponseDto extends BaseAttributeDto {
    private AddressTypeResponseDto addressTypeResponseDto;
    private CountryResponseDto countryResponseDto;
    private String town;
    private String street;
    private String house;
}
