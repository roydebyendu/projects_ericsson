package com.debyendu.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.debyendu.jpa.model.Employee;
import com.debyendu.jpa.dao.EmployeeDAO;

@Service
public class EmployeeService {

    @Autowired
	EmployeeDAO<Employee> employeeDAO;

	@Transactional
	public List<Employee> getAllEmployees() {
		return (List<Employee>) employeeDAO.findAll();
	}

	@Transactional
	public List<Employee> findByName(String name) {
		return employeeDAO.findByEname(name);
	}

	@Transactional
	public Employee getById(Long id) {
		return employeeDAO.findOne(id);
	}

	@Transactional
	public void deleteEmployee(Long employeeId) {
		employeeDAO.delete(employeeId);
	}

	@Transactional
	public boolean addEmployee(Employee employee) {
		return employeeDAO.save(employee) != null;
	}

	@Transactional
	public boolean updateEmployee(Employee employee) {
		return employeeDAO.save(employee) != null;
	}
   
}