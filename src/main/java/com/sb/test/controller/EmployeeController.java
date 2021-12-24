package com.sb.test.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sb.test.exception.ResourceNotFoundException;
import com.sb.test.model.Employee;
import com.sb.test.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4201")
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	/**
	 * Get All users.
	 */
//	@GetMapping("/employees",   headers={"Accept=application/json"})
	@RequestMapping(value = "/employees", method = RequestMethod.GET, headers = { "Accept=application/json" })
	@ResponseStatus(HttpStatus.OK)
	public List<Employee> getUsers() {
		return employeeService.getAll();
	}

	/**
	 * Gets users by id.
	 */
	@GetMapping("/employees/{eid}")
	public ResponseEntity<Employee> getUsersById(@PathVariable(value = "eid") int id) throws ResourceNotFoundException {
		return employeeService.getById(id);
	}

	/**
	 * create new user
	 */
	@PostMapping("/employees")
	Employee addUser(@Valid @RequestBody Employee employee) {
		return employeeService.create(employee);
	}

	/**
	 * update user
	 */
	@PutMapping("/employees/{eid}")
	public ResponseEntity<Employee> updateUser(@PathVariable(value = "eid") int id,
			@Valid @RequestBody Employee employee) throws ResourceNotFoundException {

		return employeeService.update(id, employee);
	}

	/**
	 * delete user
	 */
	@DeleteMapping("/employees/{eid}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "eid") int id) throws ResourceNotFoundException {
		return employeeService.delete(id);
	}

}
