package de.seriestracker.annotations;

import de.seriestracker.annotations.validators.EitherOrValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EitherOrValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface EitherOr {
    String message() default "Only one property must be not null";

    String[] fields();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
