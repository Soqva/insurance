package com.s0qva.insurance.exception;

public class EntityAliasNotFoundException extends RuntimeException {
    public static final String DEFAULT_EXCEPTION_MESSAGE_PLACEHOLDER = "Entity alias must be set!";

    public EntityAliasNotFoundException() {
        this(DEFAULT_EXCEPTION_MESSAGE_PLACEHOLDER);
    }

    public EntityAliasNotFoundException(String message) {
        super(message);
    }

    public EntityAliasNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityAliasNotFoundException(Throwable cause) {
        this(DEFAULT_EXCEPTION_MESSAGE_PLACEHOLDER, cause);
    }
}
