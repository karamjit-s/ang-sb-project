package com.sb.test.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.sb.test.exception.ResourceNotFoundException;
import com.sb.test.model.WireframeModel;

public interface WireframeService {

	/* GET */
	public List<WireframeModel> getAll();

	/* GET by ID */
	public ResponseEntity<WireframeModel> getById(int id) throws ResourceNotFoundException;

	public WireframeModel create(WireframeModel ohwfModel);

	public ResponseEntity<WireframeModel> update(int id, WireframeModel ohwfModel) throws ResourceNotFoundException;

	public Map<String, Boolean> delete(int id) throws ResourceNotFoundException;


}
