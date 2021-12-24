package com.sb.test.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.sb.test.exception.ResourceNotFoundException;
import com.sb.test.model.Employee;

public interface EmployeeService {

	/* GET */
	public List<Employee> getAll();

	/* GET by ID */
	public ResponseEntity<Employee> getById(int id) throws ResourceNotFoundException;

	public Employee create(Employee employee);

	public ResponseEntity<Employee> update(int id, Employee employee) throws ResourceNotFoundException;

	public Map<String, Boolean> delete(int id) throws ResourceNotFoundException;

}
