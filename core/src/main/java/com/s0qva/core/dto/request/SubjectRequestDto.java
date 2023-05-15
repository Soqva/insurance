package com.s0qva.core.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubjectRequestDto {
    private final Long id;
    private final String subjectTypeCode;
}
