package com.debyendu.spring.controllers;


import java.util.List;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.debyendu.spring.managers.EmployeeDataManager;



@Controller
//@PropertySource(value = "file:///${myConfigDirectory}/egecko-current.properties")
@PropertySources({
	@PropertySource(value = "classpath:db.properties"),
	@PropertySource(value = "classpath:egecko-default.properties")})
public class HelloController {

	final static Logger logger = Logger.getLogger(HelloController.class);
	
	@Autowired
	EmployeeDataManager employeeDataManager;
	
	//<Parameter name="myConfigDirectory" value="C:/myConfig" override="false"/> put in context.xml file in tomcat.
	@Value("${egecko.consumer.radiusApi.beanName}")
	private String fileName;
	
	@GetMapping("/hello")
	public String hello(Model model) {
		try {
			model.addAttribute("employeeList", employeeDataManager.getEmployeeList());
			model.addAttribute("fileName", fileName);
			logger.info("Data is sent to UI.");
		}catch(Exception e) {

		}
		return "welcome";
	}
	
	
	
}
