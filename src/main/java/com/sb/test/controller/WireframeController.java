package com.sb.test.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.sb.test.model.WireframeModel;
import com.sb.test.service.Wf_fp_service;
import com.sb.test.service.WireframeService;

@RestController
@CrossOrigin(origins = "http://localhost:4201")
@RequestMapping("/api/ohwf")
public class WireframeController {

	@Autowired
	WireframeService ohwfService;
	
	@Autowired
	Wf_fp_service wf_fp_service;

	
	/**
	 * Get All users.
	 */

	@RequestMapping(value = "/ohwf", method = RequestMethod.GET, headers = { "Accept=application/json" })
	@ResponseStatus(HttpStatus.OK)
	public List<WireframeModel> getUsers() {
		return ohwfService.getAll();
	}

	/**
	 * Gets users by id.
	 */
	@GetMapping("/ohwf/{ohwf_id}")
	public ResponseEntity<WireframeModel> getUsersById(@PathVariable(value = "ohwf_id") int id)
			throws ResourceNotFoundException {
		return ohwfService.getById(id);
	}

	/**
	 * create new user
	 */
	@PostMapping("/ohwf")
	WireframeModel addUser(@Valid @RequestBody WireframeModel ohwfModel) {
		
//		Wf_field_properties wf_field_properties = new Wf_field_properties();
//		wf_fp_service.create(wf_field_properties);
		
		return ohwfService.create(ohwfModel);
	}

	/**
	 * update user
	 */
	@PutMapping("/ohwf/{ohwf_id}")
	public ResponseEntity<WireframeModel> updateUser(@PathVariable(value = "ohwf_id") int id,
			@Valid @RequestBody WireframeModel ohwfModel) throws ResourceNotFoundException {

		return ohwfService.update(id, ohwfModel);
	}

	/**
	 * delete user
	 */
	@DeleteMapping("/ohwf/{ohwf_id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "ohwf_id") int id) throws ResourceNotFoundException {
		return ohwfService.delete(id);
	}
	
	
	/**
	 * delete user
	 */
	
//	@GetMapping("/ohwf/{ohwf_id}/buildwf")
//	public ResponseEntity<WireframeModel> buildWireframe(@PathVariable(value = "ohwf_id") int id)
//			throws ResourceNotFoundException {
//		
//		System.out.println("buildWireframe controller called");
//		
//		return ohwfService.getById(id);
//	}
//	
	
	


}
