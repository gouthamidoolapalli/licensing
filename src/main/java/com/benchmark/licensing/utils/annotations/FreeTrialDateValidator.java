package com.benchmark.licensing.utils.annotations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FreeTrialDateValidator implements 
ConstraintValidator<FreeTrialDate, String> {
	FreeTrialDate freeTrialDate;

	@Override
	public void initialize(FreeTrialDate freeTrialDate) {
		this.freeTrialDate = freeTrialDate;
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// disable existing violation message
        context.disableDefaultConstraintViolation();

		return isValidDate(this.freeTrialDate, value, context);
	}

	private boolean isValidDate(FreeTrialDate freeTrialDate, String value, ConstraintValidatorContext context) {
		Date trialDate = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(freeTrialDate.format());
			if (value != null){
				trialDate = sdf.parse(value);
				if (value.equals(sdf.format(trialDate))) {
					Date currentDate = new Date();
					Calendar calendar = new GregorianCalendar(/* remember about timezone! */);
					calendar.setTime(currentDate);
					calendar.add(Calendar.DATE, freeTrialDate.maxSubscriptionDays());
					Date subScriptionEndDate = calendar.getTime();
					if (trialDate.toInstant().isBefore(subScriptionEndDate.toInstant()) && !trialDate.toInstant().isBefore(currentDate.toInstant())) {
						return true; 
					}else {
						 customMessageForValidation(context, "Incorrect date entered");
						return false;
					}
				}else {
					 customMessageForValidation(context, "Incorrect date format. Date must be " + freeTrialDate.format());
					return false;
				}
			}


		} catch (ParseException ex) {
			 customMessageForValidation(context, "date format should be like " + freeTrialDate.format());
			ex.printStackTrace();
		}
		return false;
	}
	
	 private void customMessageForValidation(ConstraintValidatorContext constraintContext, String message) {
	        // build new violation message and add it
	        constraintContext.buildConstraintViolationWithTemplate(message).addConstraintViolation();
	    }

}
