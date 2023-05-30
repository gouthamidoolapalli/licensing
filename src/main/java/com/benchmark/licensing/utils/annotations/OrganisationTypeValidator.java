package com.benchmark.licensing.utils.annotations;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class OrganisationTypeValidator implements ConstraintValidator<OrganisationType, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		List<String> orgType=Arrays.asList("IT","Banking","Government","Others");
		return orgType.contains(value);
	}
	

}
