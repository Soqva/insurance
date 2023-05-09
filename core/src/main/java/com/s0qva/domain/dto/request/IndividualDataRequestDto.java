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
public class IndividualDataRequestDto extends BaseAttributeDto {
    private SubjectRequestDto subjectRequestDto;
    private String lastName;
    private String firstName;
    private String middleName;
    private String snils;
    private String inn;
    private String ogrn;
}
