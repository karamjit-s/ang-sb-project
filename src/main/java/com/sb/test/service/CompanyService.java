package com.sb.test.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.sb.test.exception.ResourceNotFoundException;
import com.sb.test.model.Company;

public interface CompanyService {
	/* GET */
	public List<Company> getAll();

	/* GET by ID */
	public ResponseEntity<Company> getById(int id) throws ResourceNotFoundException;

	public Company create(Company company);

	public ResponseEntity<Company> update(int id, Company company) throws ResourceNotFoundException;

	public Map<String, Boolean> delete(int id) throws ResourceNotFoundException;

}
