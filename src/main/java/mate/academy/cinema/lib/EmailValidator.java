package mate.academy.cinema.lib;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailConstraint, String> {

    @Override
    public void initialize(EmailConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String contactField,
                           ConstraintValidatorContext constraintValidatorContext) {
        return contactField != null && contactField.matches("^[A-Za-z0-9+_.-]+@(.+)$")
                && (contactField.length() > 5) && (contactField.length() < 100);
    }
}
