package com.example.autographEV.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidNameValidator implements ConstraintValidator <ValidName, String>{
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value.matches("[a-z0-9]+")){
            return true;
        }
        else {
            return false;
        }
    }
}
