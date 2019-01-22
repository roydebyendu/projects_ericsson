package com.debyendu.jpa.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.debyendu.jpa.model.Employee;


public interface EmployeeDAO <P> extends CrudRepository<Employee, Long> {
    List<Employee> findByEname(String firstName);
}
