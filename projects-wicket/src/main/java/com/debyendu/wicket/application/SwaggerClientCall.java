package com.debyendu.wicket.application;

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

//import com.debyendu.client.EmployeeInformation;
//import com.debyendu.client.EmployeeInformationImpl;


import com.debyendu.model.Employee;

public class SwaggerClientCall {
	
	public String callService() {
		String output=null;
		/*try {
			
			ApiClient apiClient = new ApiClient();
			System.out.println(apiClient.getBasePath());
			EmployeeApi employeeApi = new EmployeeApi(apiClient);
			Employee e = employeeApi.getEmployeeDetails("9836775124");
			output = e.toString(); 
			
		}catch(ApiException e) {
			System.out.println(e);
		}*/	
		return output;
	}
	
}
