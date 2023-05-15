package com.s0qva.core.dto.request;

import com.s0qva.core.dto.base.BaseAttributeDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class IndividualDataRequestDto extends BaseAttributeDto {
    private final SubjectRequestDto subjectRequestDto;
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final String snils;
    private final String inn;
    private final String ogrn;
}
