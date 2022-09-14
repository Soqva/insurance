package com.s0qva.insurance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JpqlQuery {
    private String operationName;
    private String query;
    private String repositoryName;
}
