package com.debyendu.client;

import java.util.List;

import com.debyendu.model.Employee;

public interface EmployeeInformation {
	
	List<Employee> getAllEmployeeList() throws Exception;
	List<Employee> getEmployeeList(String searchString) throws Exception;
	List<Employee> insertEmployee(Employee employee) throws Exception;	
}
