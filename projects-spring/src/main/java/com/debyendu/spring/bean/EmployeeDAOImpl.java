package com.debyendu.spring.bean;


import org.apache.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.debyendu.model.Employee;
import com.debyendu.spring.exceptions.ApplicationException;

@Repository ("employeeDao")
@ComponentScan(basePackages = "com.debyendu.spring")
public class EmployeeDAOImpl implements EmployeeDAO{

	final static Logger logger = Logger.getLogger(EmployeeDAOImpl.class);
	
	public List<Employee> getAllEmployee(Connection con) throws ApplicationException {
		List<Employee> employeeList = new ArrayList<Employee>();
		Employee employee = new Employee();
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql = "Select * from employee";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				employee = new Employee();
				employee.setEmpId(rs.getString("eid"));
				employee.setEmpName(rs.getString("ename"));
				employee.setEmpSalary(rs.getString("salary"));
				employee.setEmpDesignation(rs.getString("deg"));
				employeeList.add(employee);
			}
		}catch(SQLException e) {
			throw new ApplicationException(e); 
		}
		logger.debug("Data is retrieve from database.");
		return employeeList;
	}

}
