package com.exercise.uidemo.web;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;
import java.time.LocalDate;

public class DateRangeValidator implements ConstraintValidator<DateRangeConstraint, Object> {
	
	String date1;
	String date2;
	
	public void initialize(DateRangeConstraint constraint) {
		this.date1 = constraint.date1();
        this.date2 = constraint.date2();
    }

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		
		
		 		Object date1Value = new BeanWrapperImpl(obj).getPropertyValue(date1);
		        Object date2Value = new BeanWrapperImpl(obj).getPropertyValue(date2);
		        if(date1Value!="" && date2Value!="") {       
			        LocalDate d1 = LocalDate.parse(date1Value.toString());
			        LocalDate d2 = LocalDate.parse(date2Value.toString());
			        
			/*
			 * if(!d1.isBefore(d2)){ context.disableDefaultConstraintViolation();
			 * context.buildConstraintViolationWithTemplate(context.
			 * getDefaultConstraintMessageTemplate())
			 * .addPropertyNode("endDate").addConstraintViolation(); }
			 */
			       return d1.isBefore(d2) || d1.isEqual(d2);    
		        }       
		return false;
		
	}


}
