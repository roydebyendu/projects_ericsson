package com.debyendu.springboot.application;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.debyendu.springboot.jpa.model.Employee;
import com.debyendu.springboot.jpa.repository.EmployeeRepository;

@SpringBootApplication
@ComponentScan(basePackages = { "com.debyendu.springboot.controller" })
@Component("springBootDataJpaApplication")
public class SpringBootDataJpaApplication {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootDataJpaApplication.class, args);
	}
}
