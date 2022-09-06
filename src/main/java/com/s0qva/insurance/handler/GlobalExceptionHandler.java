package com.s0qva.insurance.handler;

import com.s0qva.insurance.exception.EntityCreationException;
import com.s0qva.insurance.exception.NoSuchEntityException;
import com.s0qva.insurance.exception.NoSuchInsuranceCompanyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({NoSuchInsuranceCompanyException.class})
    public ResponseEntity<IncorrectDataContainer> handleNoSuchEntityException(NoSuchEntityException exception) {
        IncorrectDataContainer container = buildContainer(exception);

        return new ResponseEntity<>(container, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({EntityCreationException.class})
    public ResponseEntity<IncorrectDataContainer> handleEntityCreationException(EntityCreationException exception) {
        IncorrectDataContainer container = buildContainer(exception);

        return new ResponseEntity<>(container, HttpStatus.NOT_FOUND);
    }

    private IncorrectDataContainer buildContainer(Exception exception) {
        IncorrectDataContainer container = new IncorrectDataContainer();
        String error = StringUtils.uncapitalize(exception.getClass().getSimpleName());
        String errorDescription = exception.getMessage();

        container.put(error, errorDescription);
        return container;
    }

    private static class IncorrectDataContainer {
        public final Map<String, String> errors = new HashMap<>();

        public void put(String error, String errorDescription) {
            errors.put(error, errorDescription);
        }
    }
}
