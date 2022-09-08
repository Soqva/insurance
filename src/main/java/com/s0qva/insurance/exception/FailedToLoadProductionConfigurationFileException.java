package com.s0qva.insurance.exception;

public class FailedToLoadProductionConfigurationFileException extends RuntimeException {
    public static final String DEFAULT_EXCEPTION_MESSAGE_PLACEHOLDER = "Failed to load the configuration file!";

    public FailedToLoadProductionConfigurationFileException() {
        this(DEFAULT_EXCEPTION_MESSAGE_PLACEHOLDER);
    }

    public FailedToLoadProductionConfigurationFileException(String message) {
        super(message);
    }

    public FailedToLoadProductionConfigurationFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public FailedToLoadProductionConfigurationFileException(Throwable cause) {
        this(DEFAULT_EXCEPTION_MESSAGE_PLACEHOLDER, cause);
    }
}
