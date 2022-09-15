package com.s0qva.insurance.exception;

public class SetClauseNotFoundException extends RuntimeException {
    public static final String DEFAULT_EXCEPTION_MESSAGE_PLACEHOLDER = "Using an update jpql operation " +
            "a set clause must be set!";

    public SetClauseNotFoundException() {
        this(DEFAULT_EXCEPTION_MESSAGE_PLACEHOLDER);
    }

    public SetClauseNotFoundException(String message) {
        super(message);
    }

    public SetClauseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SetClauseNotFoundException(Throwable cause) {
        this(DEFAULT_EXCEPTION_MESSAGE_PLACEHOLDER, cause);
    }
}
