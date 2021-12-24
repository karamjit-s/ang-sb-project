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
import com.sb.test.model.SignUpModel;
import com.sb.test.service.SignUpService;

@RestController
@CrossOrigin(origins = "http://localhost:4201")
@RequestMapping("/api/signup")
public class SignUpController {

	@Autowired
	SignUpService signUpService;

	/**
	 * Get All users.
	 */
//	@GetMapping("/employees",   headers={"Accept=application/json"})
	@RequestMapping(value = "/signup", method = RequestMethod.GET, headers = { "Accept=application/json" })
	@ResponseStatus(HttpStatus.OK)
	public List<SignUpModel> getUsers() {
		return signUpService.getAll();
	}

	/**
	 * Gets users by id.
	 */
	@GetMapping("/signup/{eid}")
	public ResponseEntity<SignUpModel> getUsersById(@PathVariable(value = "eid") int id)
			throws ResourceNotFoundException {
		return signUpService.getById(id);
	}

	/**
	 * create new user
	 */
	@PostMapping("/signup")
	SignUpModel addUser(@Valid @RequestBody SignUpModel signUpModel) {
		return signUpService.create(signUpModel);
	}

	/**
	 * update user
	 */
	@PutMapping("/siginup/{eid}")
	public ResponseEntity<SignUpModel> updateUser(@PathVariable(value = "eid") int id,
			@Valid @RequestBody SignUpModel signUpModel) throws ResourceNotFoundException {

		return signUpService.update(id, signUpModel);
	}

	/**
	 * delete user
	 */
	@DeleteMapping("/signup/{eid}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "eid") int id) throws ResourceNotFoundException {
		return signUpService.delete(id);
	}

}
