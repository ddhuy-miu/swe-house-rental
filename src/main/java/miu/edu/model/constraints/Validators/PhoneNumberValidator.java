package miu.edu.model.constraints.Validators;

import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import miu.edu.model.constraints.PhoneNumberConstraint;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberConstraint, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Pattern.matches("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$", value);
    }
    
}
