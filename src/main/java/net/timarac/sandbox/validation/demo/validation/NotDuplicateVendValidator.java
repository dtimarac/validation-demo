package net.timarac.sandbox.validation.demo.validation;

import net.timarac.sandbox.validation.demo.SomeRepositoryOrService;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Service
public class NotDuplicateVendValidator implements ConstraintValidator<NotDuplicateVend, Long> {

    private final SomeRepositoryOrService someRepositoryOrService;

    public NotDuplicateVendValidator(SomeRepositoryOrService someRepositoryOrService) {
        this.someRepositoryOrService = someRepositoryOrService;
    }

    @Override
    public void initialize(NotDuplicateVend constraintAnnotation) {
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return someRepositoryOrService.findById(value).isEmpty();
    }
}
