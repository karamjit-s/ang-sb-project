package com.sb.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.test.exception.ResourceNotFoundException;
import com.sb.test.model.Wf_field_properties;
import com.sb.test.service.Wf_fp_service;
import com.sb.test.service.WireframeService;

@RestController
@CrossOrigin(origins = "http://localhost:4201")
@RequestMapping("/wfb")
public class WireframeBuilderController{
	
	@Autowired
	Wf_fp_service wf_fp_service;
	
	@Autowired
	WireframeService wireframeService;
	
	@Autowired
	Wf_fp_service wf_fp_Service;
	
	/**
	 * Gets users by id.
	 */
	@GetMapping("/wfb/{ohwf_id}")
	public ResponseEntity<Wf_field_properties> getUsersById(@PathVariable(value = "ohwf_id") int id)
			throws ResourceNotFoundException {
		
		System.out.println("wireframe_builder controller in WireframeBuilderController class called with id == "+id);
		
		int h_id = id;
		
		return wf_fp_Service.getById(h_id);

	}
	
	
	
}
