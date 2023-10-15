package edu.cesur.fullstack.validators;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


@Retention(RUNTIME)
@Target(FIELD)

@Constraint(validatedBy = ValidCode.class)
public @interface CodeValidation {
	
	String message() default "Código inválido." 
			+ " Debe contener exactamente 3 letras seguidas de 3 números.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
