package com.sb.test.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.sb.test.exception.ResourceNotFoundException;
import com.sb.test.model.SignUpModel;

public interface SignUpService {

	/* GET */
	public List<SignUpModel> getAll();

	/* GET by ID */
	public ResponseEntity<SignUpModel> getById(int id) throws ResourceNotFoundException;

	public SignUpModel create(SignUpModel signUpModel);

	public ResponseEntity<SignUpModel> update(int id, SignUpModel signUpModel) throws ResourceNotFoundException;

	public Map<String, Boolean> delete(int id) throws ResourceNotFoundException;

}
