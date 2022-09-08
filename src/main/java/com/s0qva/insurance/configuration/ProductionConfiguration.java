package com.s0qva.insurance.configuration;

import com.s0qva.insurance.loader.ProductionConfigurationLoader;
import com.s0qva.insurance.property.ProductionConfigurationPropertyHolder;
import com.s0qva.insurance.property.ProductionDatabaseConfigurationProperty;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import java.nio.file.Path;

@Configuration
@Profile("production")
public class ProductionConfiguration {
    private final ProductionConfigurationLoader productionConfigurationLoader;
    private final Path pathToProductionConfigurationFile;

    @Autowired
    public ProductionConfiguration(ProductionConfigurationLoader productionConfigurationLoader,
                                   @Value("${production-configuration-file.path}") String pathToProductionConfigurationFile) {
        this.productionConfigurationLoader = productionConfigurationLoader;
        this.pathToProductionConfigurationFile = Path.of(pathToProductionConfigurationFile);
    }

    @Bean
    public ProductionConfigurationPropertyHolder productionConfigurationPropertyHolder() {
        return productionConfigurationLoader.load(pathToProductionConfigurationFile);
    }

    @Configuration
    @Profile("production")
    public static class ProductionDatabaseConfiguration {

        @Bean
        public DataSource dataSource(ProductionConfigurationPropertyHolder productionConfigurationPropertyHolder) {
            ProductionDatabaseConfigurationProperty databaseConfigurationProperty = productionConfigurationPropertyHolder
                    .getDatabaseConfigurationProperty();
            HikariConfig hikariConfig = new HikariConfig();

            hikariConfig.setJdbcUrl(databaseConfigurationProperty.getDatabaseUrl());
            hikariConfig.setUsername(databaseConfigurationProperty.getUsername());
            hikariConfig.setPassword(databaseConfigurationProperty.getPassword());
            return new HikariDataSource(hikariConfig);
        }
    }
}
