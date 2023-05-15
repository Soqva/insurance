package com.s0qva.core.dataenum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AddressTypeEnum {
    FACT("FACT", "Фактический адрес"),
    JURIDICAL("JURIDICAL", "Юридический адрес");

    private final String code;
    private final String description;
}
