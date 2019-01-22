package com.debyendu.client;


import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.debyendu.client.swagger.resource.EmployeeApi;
import com.debyendu.client.swagger.invoker.ApiClient;
import com.debyendu.client.swagger.invoker.ApiException;

import com.debyendu.model.Employee;
//import com.debyendu.client.swagger.model.Employee;
import com.debyendu.client.adaptor.EmployeeInformationAdaptor;

public class EmployeeInformationImpl implements EmployeeInformation {
	
	EmployeeApi employeeApi;
	List<Employee> employeeList;
	EmployeeInformationAdaptor employeeInformationAdaptor;
	public EmployeeInformationImpl(){
		try {
			
			ApiClient apiClient = new ApiClient();
			System.out.println(apiClient.getBasePath());
			employeeApi = new EmployeeApi(apiClient);

			employeeInformationAdaptor = new EmployeeInformationAdaptor();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public List<Employee> getEmployeeList(String searchString) throws Exception {
		try {

			employeeList = employeeInformationAdaptor.convertServiceResponse(employeeApi.getEmployeeList(searchString));	

		}catch(ApiException ae){
			throw ae;
		}
		return employeeList;
	}
	
	public List<Employee> getAllEmployeeList() throws Exception {
		try {

			employeeList = employeeInformationAdaptor.convertServiceResponse(employeeApi.getAllEmployeeList());	

		}catch(ApiException ae){
			throw ae;
		}
		return employeeList;
	}
	
	public List<Employee> insertEmployee(Employee employee) throws Exception {
		try {

			employeeList = employeeInformationAdaptor.convertServiceResponse(employeeApi.insertEmployee(employeeInformationAdaptor.convertServiceRequest(employee)));	

		}catch(ApiException ae){
			throw ae;
		}
		return employeeList;
	}
	
}
