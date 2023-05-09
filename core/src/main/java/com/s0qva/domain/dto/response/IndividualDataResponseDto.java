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
public class IndividualDataResponseDto extends BaseAttributeDto {
    private String lastName;
    private String firstName;
    private String middleName;
    private String snils;
    private String inn;
    private String ogrn;
}
