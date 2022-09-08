package com.s0qva.insurance.exception;

public class InsuranceCompanyCreationException extends EntityCreationException {
    public static final String DEFAULT_EXCEPTION_MESSAGE_PLACEHOLDER = "Failed to create the insurance company";

    public InsuranceCompanyCreationException() {
        this(DEFAULT_EXCEPTION_MESSAGE_PLACEHOLDER);
    }

    public InsuranceCompanyCreationException(String message) {
        super(message);
    }

    public InsuranceCompanyCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsuranceCompanyCreationException(Throwable cause) {
        this(DEFAULT_EXCEPTION_MESSAGE_PLACEHOLDER, cause);
    }
}
