package com.debyendu.springboot.jpa.model;

import com.debyendu.springboot.jpa.model.Employee;
import java.util.ArrayList;
import java.util.List;


public class Employees   {
  private List<Employee> employeeList = new ArrayList<Employee>();

  public Employees employeeList(List<Employee> employeeList) {
    this.employeeList = employeeList;
    return this;
  }

	public List<Employee> getEmployeeList() {
    return employeeList;
  }

  public void setEmployeeList(List<Employee> employeeList) {
    this.employeeList = employeeList;
  }

}

