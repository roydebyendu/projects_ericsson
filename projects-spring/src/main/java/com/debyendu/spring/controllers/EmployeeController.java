package com.debyendu.spring.controllers;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.debyendu.model.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	final static Logger logger = Logger.getLogger(EmployeeController.class);
	
	@RequestMapping("/showForm")
	public String showForm(Model model){
		model.addAttribute("employee", new Employee());
		return "employeeForm";
	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult){
		
		logger.info("Binding Result : " + bindingResult);
		
		if(bindingResult.hasErrors()){
			return "employeeForm";
		}else{
			return "welcome";
		}

	}

}
