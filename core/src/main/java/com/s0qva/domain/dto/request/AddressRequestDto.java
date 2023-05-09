package com.s0qva.domain.dto.request;

import com.s0qva.domain.dto.base.BaseAttributeDto;
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
public class AddressRequestDto extends BaseAttributeDto {
    private Long subjectId;
    private String addressTypeCode;
    private String countryCode;
    private String town;
    private String street;
    private String house;
}
