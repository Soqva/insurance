package com.s0qva.insurance.exception;

public class InvalidJpqlQueryException extends RuntimeException {
    public static final String DEFAULT_EXCEPTION_MESSAGE_PLACEHOLDER = "Invalid jpql query has been received!";

    public InvalidJpqlQueryException() {
        this(DEFAULT_EXCEPTION_MESSAGE_PLACEHOLDER);
    }

    public InvalidJpqlQueryException(String message) {
        super(message);
    }

    public InvalidJpqlQueryException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidJpqlQueryException(Throwable cause) {
        this(DEFAULT_EXCEPTION_MESSAGE_PLACEHOLDER, cause);
    }
}
