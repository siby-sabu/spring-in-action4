package com.spittr;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class SpitterValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Spitter.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.empty", "First name cannot be empty");
		
		Spitter spitter = (Spitter) target;
		if(spitter.getFirstName().length()<2) {
			errors.rejectValue("firstName", "firstName.min.length", "First Name minimum lenght should be 2");
		}
		if(spitter.getFirstName().length()> 30) {
			errors.rejectValue("firstName", "firstName.max.length", "First Name maximum lenght less be 30");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.empty", "Last name cannot be empty");
		
		if(spitter.getLastName().length()<2) {
			errors.rejectValue("lastName", "lastName.min.length", "Last Name minimum lenght should be 2");
		}
		if(spitter.getLastName().length()> 30) {
			errors.rejectValue("lastName", "lastName.max.length", "Last Name maximum lenght less be 30");
		}
		
		
		
		
	}

}
