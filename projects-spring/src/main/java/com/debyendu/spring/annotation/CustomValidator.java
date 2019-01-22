package com.debyendu.spring.annotation;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component("customValidator")
@ComponentScan(basePackages = "com.debyendu.spring")
public class CustomValidator implements ConstraintValidator<CustomAnnotaion, String>{

	final static Logger logger = Logger.getLogger(CustomValidator.class);
	
	public String message;
    public String[] values;
	
    @Override
    public void initialize(CustomAnnotaion customAnnotaion)
    {
        this.message = customAnnotaion.message();
        this.values = customAnnotaion.values();
    }
 
    @Override
    public boolean isValid(String value, ConstraintValidatorContext arg1)
    {
        List<String> lstValues = Arrays.asList(values);
 
        logger.info("In Customer validator : " + lstValues.get(0));
        
        return value != null && !value.isEmpty() && lstValues.contains(value);
    }

}
