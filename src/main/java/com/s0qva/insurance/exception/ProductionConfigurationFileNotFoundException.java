package com.s0qva.insurance.exception;

public class ProductionConfigurationFileNotFoundException extends RuntimeException {
    public static final String DEFAULT_EXCEPTION_MESSAGE_PLACEHOLDER = "Production configuration file not found!";

    public ProductionConfigurationFileNotFoundException() {
        this(DEFAULT_EXCEPTION_MESSAGE_PLACEHOLDER);
    }

    public ProductionConfigurationFileNotFoundException(String message) {
        super(message);
    }

    public ProductionConfigurationFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductionConfigurationFileNotFoundException(Throwable cause) {
        this(DEFAULT_EXCEPTION_MESSAGE_PLACEHOLDER, cause);
    }
}
