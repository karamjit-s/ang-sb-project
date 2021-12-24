package com.sb.test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sb.test.exception.ResourceNotFoundException;
import com.sb.test.model.Employee;
import com.sb.test.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	/* GET */
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	/* GET by ID */
	public ResponseEntity<Employee> getById(int id) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + id));
		return ResponseEntity.ok().body(employee);
	}

	public Employee create(Employee employee) {
		return employeeRepository.save(employee);
	}

	public ResponseEntity<Employee> update(int id, Employee employee) throws ResourceNotFoundException {

		Employee employee1 = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

		employee1.setFirst_name(employee.getFirst_name());
		employee1.setLast_name(employee.getLast_name());
		employee1.setEmail_id(employee.getEmail_id());

		final Employee updatedUser = employeeRepository.save(employee1);
		return ResponseEntity.ok(updatedUser);
	}

	public Map<String, Boolean> delete(int id) throws ResourceNotFoundException {
		Employee rn_users = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

		employeeRepository.delete(rn_users);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
