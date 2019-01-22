package com.debyendu.springboot.application;

import java.util.Properties;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.beans.factory.annotation.Autowired;

//To deploy the war in tomcat

//@SpringBootApplication
public class SpringBootTomcatApplication extends SpringBootServletInitializer {
	//@Autowired
	//SpringBootDataJpaApplication springBootDataJpaApplication;
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
       Properties defaultProperties = new Properties();
       
       return application.properties(defaultProperties ).sources(SpringBootDataJpaApplication.class);
    }
	
}
