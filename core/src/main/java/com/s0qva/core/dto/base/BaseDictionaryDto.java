package com.s0qva.core.dto.base;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class BaseDictionaryDto {
    private final String code;
    private final String description;
}
