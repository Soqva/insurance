package com.s0qva.core.dataenum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SubjectTypeEnum {
    LEGAL_ENTITY("LEGAL_ENTITY", "Юридическое лицо"),
    INDIVIDUAL("INDIVIDUAL", "Физическое лицо");

    private final String code;
    private final String description;
}
