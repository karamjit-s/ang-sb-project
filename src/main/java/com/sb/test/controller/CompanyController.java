package com.sb.test.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.test.exception.ResourceNotFoundException;
import com.sb.test.model.Company;
import com.sb.test.service.CompanyService;

@RestController
@CrossOrigin(origins = "http://localhost:4201")
@RequestMapping("/api/c1")
public class CompanyController {

	@Autowired
	CompanyService companyService;

	/**
	 * Get All users.
	 */
	@GetMapping("/company")
	public List<Company> getUsers() {
		return companyService.getAll();
	}

	/**
	 * Gets users by id.
	 */
	@GetMapping("/company/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable(value = "id") int id) throws ResourceNotFoundException {
		return companyService.getById(id);
	}

	/**
	 * create new user
	 */
	@PostMapping("/company")
	Company addCompany(@Valid @RequestBody Company company) {
		return companyService.create(company);
	}

	/**
	 * update user
	 */
	@PutMapping("/employees/{id}")
	public ResponseEntity<Company> updateCompany(@PathVariable(value = "id") int id,
			@Valid @RequestBody Company company) throws ResourceNotFoundException {

		return companyService.update(id, company);
	}

	/**
	 * delete user
	 */
	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteCompany(@PathVariable(value = "id") int id) throws ResourceNotFoundException {
		return companyService.delete(id);
	}

}
