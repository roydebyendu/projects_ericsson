package com.debyendu.springboot.jpa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;

import com.debyendu.springboot.jpa.model.Employee;

public interface EmployeeRepositoryCust {
	List<Employee> findEmployeesByName(String name);
}
