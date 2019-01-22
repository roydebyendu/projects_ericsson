package com.debyendu.springboot.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.debyendu.springboot.jpa.model.Employee;
import com.debyendu.springboot.jpa.model.Employees;
import com.debyendu.springboot.jpa.repository.EmployeeRepository;

@RestController
@EnableJpaRepositories("com.debyendu.springboot.jpa.repository")
@ComponentScan(basePackages = { "com.debyendu.springboot.jpa.repository" })
@EntityScan("com.debyendu.springboot.jpa.model") 
public class MainController {

	@Autowired
    private EmployeeRepository employeeRepository;
	
	@ResponseBody
    @RequestMapping("/")
    public String home() {
        String html = "";
        html += "<ul>";
        html += " <li><a href='/insertEmployee'>Insert Employee</a></li>";
        html += " <li><a href='/project-springboot/showEmployee'>Show Employee</a></li>";
        html += " <li><a href='/updateEmployee'>Update Employee</a></li>";
        html += " <li><a href='/deleteEmployee'>Delete Employee</a></li>";
        html += "</ul>";
        /*
        html += "<ul>";
        html += " <li><a href='/insertEmployee'>Insert Employee</a></li>";
        html += " <li><a href='/showEmployee'>Show Employee</a></li>";
        html += " <li><a href='/updateEmployee'>Update Employee</a></li>";
        html += " <li><a href='/deleteEmployee'>Delete Employee</a></li>";
        html += "</ul>";
        */
        return html;
    }
	
	@ResponseBody
    @RequestMapping("/insertEmployee")
    public String insertEmployee() {
 
		Employee employee = new Employee( );
	    employee.setEid("ntpl/786");
	    employee.setEname( "Gopal" );
	    employee.setSalary( "100000" );
	    employee.setDeg( "Lord" );
	    
	    this.employeeRepository.save(employee);
 
        return "Inserted employee : "+ employee;
    }
	
	@ResponseBody
    @RequestMapping("/insertEmployeeForSaggarClient")
    public Employees insertWicketEmployee(@RequestBody Employee employee) {
 
		this.employeeRepository.save(employee);
 
		Employees employees = new Employees();
		List<Employee> employeeList = this.employeeRepository.findByEname(employee.getEname());
        employees.employeeList(employeeList);
        return employees;
		
        //return "Inserted employee : "+ employee;
    }
	
	/*@ResponseBody
    @RequestMapping("/showEmployee")
    public String showEmployee() {
 
        Iterable<Employee> employees = this.employeeRepository.findAll();
 
        String html = "";
        for (Employee emp : employees) {
            html += emp + "<br>";
        }
 
        return html;
    }*/
	
	@ResponseBody
    @RequestMapping("/showEmployee")
    public Employees showEmployee() {
		Employees employees = new Employees();
		List<Employee> employeeList = this.employeeRepository.findAll();
		employees.employeeList(employeeList);
        return employees;
    }
	
	@ResponseBody
    @RequestMapping("/showEmployeeForSaggarClient/{empName}")
    public Employees showWicketEmployee(@PathVariable String empName) {
		Employees employees = new Employees();
		List<Employee> employeeList = this.employeeRepository.findByEname(empName);
        employees.employeeList(employeeList);
        return employees;
    }
	
	@ResponseBody
    @RequestMapping("/updateEmployee")
    public String updateEmployee() {
 
		Employee employee = new Employee( );
	    employee.setEid("ntpl/169");
	    employee.setEname( "Debyendu Roy" );
	    employee.setSalary( "85000" );
	    employee.setDeg( "Developer" );
	    
	    this.employeeRepository.save(employee);
 
        return "Updated employee : "+ employee;
    }
	
	@ResponseBody
    @RequestMapping("/deleteEmployee")
    public String deleteEmployee() {
 
		Employee employee = new Employee( );
	    employee.setEid("ntpl/169");
	    employee.setEname( "Debyendu" );
	    employee.setSalary( "85000" );
	    employee.setDeg( "Developer" );
	    
	    this.employeeRepository.delete(employee);
 
        return "Deleted employee : "+ employee;
    }
	
	
}
