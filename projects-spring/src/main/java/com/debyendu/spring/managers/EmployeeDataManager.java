package com.debyendu.spring.managers;

import java.util.List;

import com.debyendu.model.Employee;
import com.debyendu.spring.exceptions.ApplicationException;

public interface EmployeeDataManager {

	public List<Employee> getEmployeeList() throws ApplicationException; 
	
}
