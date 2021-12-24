package com.sb.test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sb.test.exception.ResourceNotFoundException;
import com.sb.test.model.Company;
import com.sb.test.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService

{
	@Autowired
	CompanyRepository companyRepository;

	/* GET */
	public List<Company> getAll() {
		return companyRepository.findAll();
	}

	
	/* GET by ID */
	public ResponseEntity<Company> getById(int id) throws ResourceNotFoundException {
		Company employee = companyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Company not found on :: " + id));
		return ResponseEntity.ok().body(employee);
	}

	public Company create(Company employee) {
		return companyRepository.save(employee);
	}
	

	public ResponseEntity<Company> update(int id, Company company) throws ResourceNotFoundException {

		Company company1 = companyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + id));

		company1.setCompany_name(company.getCompany_name());
		company1.setLocation(company.getLocation());

		final Company updatedUser = companyRepository.save(company1);
		return ResponseEntity.ok(updatedUser);
	}

	public Map<String, Boolean> delete(int id) throws ResourceNotFoundException {
		Company company = companyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + id));

		companyRepository.delete(company);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
