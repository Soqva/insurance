package com.s0qva.insurance.exception;

public class NoSuchInsuranceCompanyException extends NoSuchEntityException {
    public static final String DEFAULT_EXCEPTION_MESSAGE_PLACEHOLDER = "There is no insurance company with id = ";

    public NoSuchInsuranceCompanyException(Long id) {
        this(DEFAULT_EXCEPTION_MESSAGE_PLACEHOLDER + id);
    }

    public NoSuchInsuranceCompanyException(String message) {
        super(message);
    }

    public NoSuchInsuranceCompanyException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchInsuranceCompanyException(Long id, Throwable cause) {
        this(DEFAULT_EXCEPTION_MESSAGE_PLACEHOLDER + id, cause);
    }
}
