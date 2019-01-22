package com.debyendu.springboot.jpa.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.debyendu.springboot.jpa.model.Employee;
//public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
public interface EmployeeRepository extends CrudRepository<Employee,String>{
	
	List<Employee> findByEname(String firstName);
	
	List<Employee> findAll();
	
}
