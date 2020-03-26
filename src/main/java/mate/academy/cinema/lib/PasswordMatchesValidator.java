package mate.academy.cinema.lib;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import mate.academy.cinema.dto.UserRegistrationDto;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches,
        UserRegistrationDto> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {

    }

    @Override
    public boolean isValid(UserRegistrationDto userRegistrationDto,
                           ConstraintValidatorContext constraintValidatorContext) {
        return userRegistrationDto.getPassword().equals(userRegistrationDto.getRepeatPassword());
    }
}
