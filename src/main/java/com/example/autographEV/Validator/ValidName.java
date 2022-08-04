package com.example.autographEV.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({  FIELD,  PARAMETER, })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidNameValidator.class)
@Documented
public @interface ValidName {

    String message() default "Enter name is not valid";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
