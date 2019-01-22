package com.debyendu.client.adaptor;

import java.util.List;
import java.util.ArrayList;

import com.debyendu.client.swagger.model.Employees;
import com.debyendu.client.swagger.model.Employee;
//import com.debyendu.model.Employee;



public class EmployeeInformationAdaptor {

	 public List<com.debyendu.model.Employee> convertServiceResponse(Employees employees) {

		List<com.debyendu.model.Employee> employeeList = new ArrayList<com.debyendu.model.Employee>();
		com.debyendu.model.Employee employee;
		
		for(com.debyendu.client.swagger.model.Employee emp : employees.getEmployeeList()){
			employee = new com.debyendu.model.Employee();
			
			employee.setEmpId(emp.getEid());
			employee.setEmpName(emp.getEname());
			employee.setEmpSalary(emp.getSalary());
			employee.setEmpDesignation(emp.getDeg());
				
			employeeList.add(employee);
			System.out.println("resultResource" + employee.toString());
		}
		
	    return employeeList;
	 }
	  
	 public Employee convertServiceRequest(com.debyendu.model.Employee employee) {

		Employee emp = new Employee();
			
		emp.setEname(employee.getEmpName());
		emp.setEid(employee.getEmpId());
		emp.setSalary(employee.getEmpSalary());
		emp.setDeg(employee.getEmpDesignation());
				
		System.out.println("resultResource" + employee.toString());
		
	    return emp;
	 } 
	  
}
