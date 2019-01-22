package com.debyendu.spring.controllers;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.debyendu.model.Employee;
import com.debyendu.spring.bean.EmployeeDAO;
import com.debyendu.spring.config.TestBeanConfig;
import com.debyendu.spring.exceptions.ApplicationException;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestBeanConfig.class})
public class ControllerTest {

	@Autowired
    EmployeeDAO dao;
	
	@Autowired
	Connection con;
	
	@Test
	public void getEmployeeList_Test() throws ApplicationException {
		
		List<Employee> employeeList;
		
		employeeList = dao.getAllEmployee(con);
		
		assertNotNull(employeeList);
		assertTrue(employeeList.size() > 0);
	}
	
}
