package com.benchmark.licensing.utils.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ContactNumberValidator implements 
  ConstraintValidator<ContactNumber, String> {

    @Override
    public void initialize(ContactNumber contactNumber) {
    }

    @Override
    public boolean isValid(String contactField,
      ConstraintValidatorContext cxt) {
        return contactField != null && contactField.matches("[0-9]+")
          && (contactField.length() > 8) && (contactField.length() < 14);
    }

}
