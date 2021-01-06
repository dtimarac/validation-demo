package net.timarac.sandbox.validation.demo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = NotDuplicateVendValidator.class)
@Documented
public @interface NotDuplicateVend {

    String message() default "Vend.duplicate";

    String errorType() default "VEND_DUPLICATE";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
