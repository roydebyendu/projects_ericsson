package com.debyendu.spring.managers;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.debyendu.model.Employee;
import com.debyendu.spring.bean.EmployeeDAO;
import com.debyendu.spring.config.SpringJDBCConfiguration;
import com.debyendu.spring.exceptions.ApplicationException;

import com.debyendu.jpa.service.EmployeeService;

@Service ("employeeDataManager")
@ComponentScan(basePackages = "com.debyendu.spring")
public class EmployeeDataManagerImpl implements EmployeeDataManager{

	@Autowired
    EmployeeDAO dao;
	
	@Autowired
	Connection con;
	
	@Autowired
	EmployeeService employeeService;
	
	public List<Employee> getEmployeeList() throws ApplicationException{
		List<Employee> employeeList;
		
		employeeList = dao.getAllEmployee(con);
		
		System.out.println("This is from JPA : "+ employeeService.findByName("Debyendu"));
		
		return employeeList;
	}

}
