package com.s0qva.insurance.property;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProductionDatabaseConfigurationProperty {
    private final String databaseUrl;
    private final String username;
    private final String password;
}
