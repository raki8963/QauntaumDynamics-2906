package org.library.annotations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = YearValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ValidYear {

    String message() default "Invalid publication year , Year should consists of 4 digits";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
