/**
 * 
 */
package com.debyendu.spring.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CustomValidator.class)
@Documented
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
/**
 * @author ebeordy
 *
 */
public @interface CustomAnnotaion {

	public String message() default "Field should have Debyendu value";
	public String[] values() default {"Debyendu", "Ram"};
	 
    Class<?>[] groups() default {}; //Required by Constraint
 
    Class<? extends Payload>[] payload() default {}; //Required by Constraint
}
