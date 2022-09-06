package com.s0qva.insurance.exception;

public class EntityCreationException extends RuntimeException {

    public EntityCreationException(String message) {
        super(message);
    }

    public EntityCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
