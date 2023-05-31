package com.benchmark.licensing.utils.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = OrganisationTypeValidator.class)
public @interface OrganisationType {

	String message() default "Invalid Organisation Type!";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
}
