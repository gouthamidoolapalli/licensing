package com.benchmark.licensing.utils.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = FreeTrialDateValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface FreeTrialDate {
	String message() default "Invalid Date";
	String format() default "dd/MM/yyyy";
	int maxSubscriptionDays() default 30;
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
