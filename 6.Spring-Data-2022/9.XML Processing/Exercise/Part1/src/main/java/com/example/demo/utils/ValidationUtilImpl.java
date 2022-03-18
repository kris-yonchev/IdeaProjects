package com.example.demo.utils;

import org.springframework.stereotype.Component;

import javax.validation.Validator;

@Component
public class ValidationUtilImpl implements ValidationUtil {

    private Validator validator;

    public ValidationUtilImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public <E> boolean isValid(E entity) {
        return validator.validate(entity).isEmpty();
    }
}
