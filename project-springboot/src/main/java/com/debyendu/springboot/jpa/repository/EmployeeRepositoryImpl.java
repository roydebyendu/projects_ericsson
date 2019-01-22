package com.debyendu.springboot.jpa.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.debyendu.springboot.jpa.model.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepositoryCust {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<Employee> findEmployeesByName(String name) {
		try {
			String sql = ""; 
		}catch(NoResultException e) {
			
		}
		return null;
	}

}
