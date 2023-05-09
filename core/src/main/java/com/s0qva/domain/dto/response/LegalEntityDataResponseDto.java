package com.s0qva.domain.dto.response;

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
public class LegalEntityDataResponseDto extends BaseAttributeDto {
    private String fullName;
    private String shortName;
    private String inn;
    private String ogrn;
}
