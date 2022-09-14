package com.s0qva.insurance.loader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.s0qva.insurance.exception.FailedToLoadProductionConfigurationFileException;
import com.s0qva.insurance.exception.ProductionConfigurationFileNotFoundException;
import com.s0qva.insurance.property.ProductionConfigurationPropertyHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
@RequiredArgsConstructor
public class ProductionConfigurationLoader implements ResourceLoader<ProductionConfigurationPropertyHolder> {
    private final ObjectMapper mapper;

    @Override
    public ProductionConfigurationPropertyHolder load(Path pathToConfigFile) {
        if (Files.notExists(pathToConfigFile)) {
            throw new ProductionConfigurationFileNotFoundException();
        }
        try {
            return mapper.readValue(Files.readAllBytes(pathToConfigFile), ProductionConfigurationPropertyHolder.class);
        } catch (IOException exception) {
            throw new FailedToLoadProductionConfigurationFileException(exception);
        }
    }
}
