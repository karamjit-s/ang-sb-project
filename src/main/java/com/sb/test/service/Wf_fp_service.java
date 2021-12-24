package com.sb.test.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.sb.test.exception.ResourceNotFoundException;
import com.sb.test.model.Wf_field_properties;

public interface Wf_fp_service {

	
	/* GET */
	public List<Wf_field_properties> getAll();
	
	/* GET by ID */
	public ResponseEntity<Wf_field_properties> getById(int id) throws ResourceNotFoundException ;
	
//	public Wf_field_properties create(Wf_field_properties wf_field_properties);
		
	public ResponseEntity<Wf_field_properties> update(int id, Wf_field_properties wf_field_properties) throws ResourceNotFoundException;
	
	public Map<String, Boolean> delete(int id) throws ResourceNotFoundException;
	
	
	
}
