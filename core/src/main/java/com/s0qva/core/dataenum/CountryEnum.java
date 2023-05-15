package com.s0qva.core.dataenum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CountryEnum {
    RUSSIA("RUSSIA", "Российская Федерация");

    private final String code;
    private final String description;
}
