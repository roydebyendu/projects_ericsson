package com.debyendu.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.debyendu.jpa.service.EmployeeService;

@Configuration
@ComponentScan(basePackages = "com.debyendu.jpa")
public class AppJpaConfig{
	
	@Bean
    public EmployeeService getEmployeeService() {
        
        return new EmployeeService();
    }
	
	

}
