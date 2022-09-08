package com.s0qva.insurance.property;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;

@Data
public class ProductionConfigurationPropertyHolder {
    private final ProductionDatabaseConfigurationProperty databaseConfigurationProperty;

    @JsonCreator
    public ProductionConfigurationPropertyHolder(ProductionDatabaseConfigurationProperty databaseConfigurationProperty) {
        this.databaseConfigurationProperty = databaseConfigurationProperty;
    }
}
