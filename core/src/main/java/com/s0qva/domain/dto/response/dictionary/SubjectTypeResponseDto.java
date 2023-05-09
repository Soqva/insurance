package com.s0qva.domain.dto.response.dictionary;

import com.s0qva.domain.dto.base.BaseDictionaryDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SubjectTypeResponseDto extends BaseDictionaryDto {
}
