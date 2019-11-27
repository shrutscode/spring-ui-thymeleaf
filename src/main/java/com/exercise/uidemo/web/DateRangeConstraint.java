package com.exercise.uidemo.web;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;


@Constraint(validatedBy = DateRangeValidator.class)
@Target( { ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DateRangeConstraint {
	
	String message() default "{error.invaliddaterange}";
	String date1();
	 
    String date2();
    
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {}; 
 
    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
    	DateRangeConstraint[] value();
    }

}
