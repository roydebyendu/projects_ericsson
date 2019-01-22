package com.debyendu.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.debyendu.model.Employee;

@Path("/json")
public class JsonService {

	@GET
	@Path("/employee")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getTrackInJSON() {

		Employee employee = new Employee();
		employee.setEmpId("ntpl/169");
		employee.setEmpName("Debyendu Roy");
		employee.setEmpSalary("100000");
		employee.setEmpDesignation("Programmer");

		return employee;

	}
	
	
}
