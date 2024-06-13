package com.jjeneral.inadvancechallenge.constraint;

import com.jjeneral.inadvancechallenge.service.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CorreoDisponibleValidator implements ConstraintValidator<CorreoDisponible, String> {
    private final UserService userService;
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return userService.isEmailAvailable(s);
    }
}
