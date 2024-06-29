package org.library.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.Year;

public class YearValidator implements ConstraintValidator<ValidYear,Integer> {
    @Override
    public void initialize(ValidYear constraintAnnotation) {

    }

    @Override// to check year has 4 digits and it will not exceed the current year
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        if(value==null){
            return false;
        }
        String year = value.toString();
        return year.length()==4 && value<= Year.now().getValue();
    }
}
