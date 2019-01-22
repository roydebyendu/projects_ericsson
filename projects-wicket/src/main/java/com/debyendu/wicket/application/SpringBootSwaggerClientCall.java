package com.debyendu.wicket.application;

import java.util.List;

import com.debyendu.client.EmployeeInformation;
import com.debyendu.client.EmployeeInformationImpl;
import com.debyendu.model.Employee;

public class SpringBootSwaggerClientCall {

	public Employee getData(String searchString) {
		Employee employee=null;
		 
		try {
			EmployeeInformation employeeInformation = new EmployeeInformationImpl();
			employee = employeeInformation.getEmployeeList(searchString).get(0); 
			//output = employee.toString();
		}catch(Exception e) {
			System.out.println(e);
		}	
		return employee;
	}
	
	public List<Employee> getAllData() {
		List<Employee> employeeList=null;
		 
		try {
			EmployeeInformation employeeInformation = new EmployeeInformationImpl();
			employeeList = employeeInformation.getAllEmployeeList(); 
		}catch(Exception e) {
			System.out.println(e);
		}	
		return employeeList;
	}
	
	public Employee saveData(Employee employee) {
		 
		try {
			EmployeeInformation employeeInformation = new EmployeeInformationImpl();
			employee = employeeInformation.insertEmployee(employee).get(0); 
		}catch(Exception e) {
			System.out.println(e);
		}	
		return employee;
	}
	
}
