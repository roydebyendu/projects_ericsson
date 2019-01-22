package com.debyendu.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.debyendu.jpa.model.Employee;
import com.debyendu.jpa.service.EmployeeService;

//@RestController
public class EmployeeController {

	/*@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public @ResponseBody Employee getAllUsers(@PathVariable Long id) {
		return employeeService.getById(id);
	}

	@RequestMapping(value = "/EmployeeByName/{name}", method = RequestMethod.GET)
	public List<Employee> getEmployeeeByName(@PathVariable String name) {
		return employeeService.findByName(name);
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public List<Employee> getAll() {
		return employeeService.getAllEmployees();
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
	public HttpStatus deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return HttpStatus.NO_CONTENT;
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public HttpStatus insertEmployeee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}

	@RequestMapping(value = "/employee", method = RequestMethod.PUT)
	public HttpStatus updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}*/
}
