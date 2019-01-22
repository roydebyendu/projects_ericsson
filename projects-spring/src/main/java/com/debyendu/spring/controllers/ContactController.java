package com.debyendu.spring.controllers;

import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.debyendu.spring.model.Contact;
import com.debyendu.spring.model.Country;
import com.debyendu.spring.model.Course;


@Controller
@SessionAttributes("contactList")
//@Validated
public class ContactController {

	final static Logger logger = Logger.getLogger(ContactController.class);
	
	private Validator validator;
	
	/*public ContactController()
    {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }*/
	
	
    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public String addContact(Model model, @ModelAttribute("contactList") ArrayList<Contact> contactList, @Valid @ModelAttribute("contact") Contact contact, BindingResult result) {
    	logger.info("First Name:" + contact.getFirstname() +  "Last Name:" + contact.getLastname());

    	/*Set<ConstraintViolation<Contact>> violations = validator.validate(contact); 
    	for (ConstraintViolation<Contact> violation : violations)
        {
            String propertyPath = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            // Add JSR-303 errors to BindingResult
            // This allows Spring to display them in view via a FieldError
            result.addError(new FieldError("firstname",propertyPath, "Invalid "+ propertyPath + "(" + message + ")"));
        }*/
    	model.addAttribute("countryList", getCountryList());
    	model.addAttribute("courseList", getCourseList());
    	
    	contactList.add(contact);
    	model.addAttribute("contactList", contactList);
    	
    	
    	if(result.hasErrors()){
        	logger.info("Binding Result : " + result);
        	return "contact";
		}else{
			
			return "contact";
		}
        
    }
    /*@RequestMapping("/contact")
    public String showContact(Model model) {
    	ArrayList<Contact> contactList = new ArrayList<Contact>();
    	model.addAttribute("contactList", contactList);
    	model.addAttribute("contact", new Contact());
    	
		return "contact";
    }*/
    
    @RequestMapping("/contact")
    public String listContacts(Map<String, Object> map) {
    	
    	Contact contact = new Contact();  
    	map.put("countryList", getCountryList());
    	map.put("courseList", getCourseList());
    	map.put("contact", contact);
    	map.put("contactList", getContactList(contact));
        
        return "contact";
    }   
    
        
    private List<Country> getCountryList(){
    	List<Country> countryList = new ArrayList<Country>();
    	Country country = new Country();
    	country.setId("IND");
    	country.setName("India");
    	countryList.add(country);
    	country = new Country();
    	country.setId("USA");
    	country.setName("United States of America");
    	countryList.add(country);
    	return countryList; 
    } 

    private List<Course> getCourseList(){	
    	List<Course> courseList = new ArrayList<Course>();
    	Course course = new Course();
    	course.setId("S");
    	course.setName("Spring");
    	courseList.add(course);
    	course = new Course();
    	course.setId("J");
    	course.setName("Java");
    	courseList.add(course);
    	return courseList;
    }
    
    private List<Contact> getContactList(Contact contact){
    	ArrayList<Contact> contactList = new ArrayList<Contact>();
    	//contactList.add(contact);
    	return contactList;
    }
}
