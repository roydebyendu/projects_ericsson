package com.debyendu.spring.bean;

import java.util.List;
import java.sql.Connection;

import com.debyendu.model.Employee;
import com.debyendu.spring.exceptions.ApplicationException;

public interface EmployeeDAO {
	public List<Employee> getAllEmployee(Connection con) throws ApplicationException;
}
