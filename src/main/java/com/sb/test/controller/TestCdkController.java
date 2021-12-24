package com.sb.test.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sb.test.model.TestCdkModel;
import com.sb.test.service.TestCdkService;

@RestController
@CrossOrigin(origins = "http://localhost:4201")
@RequestMapping("/testcdk")
public class TestCdkController {
	
	@Autowired
	TestCdkService testCdkService;

	/**
	 * Get All users.
	 */
//	@GetMapping("/employees",   headers={"Accept=application/json"})
	@RequestMapping(value = "/testcdk", method = RequestMethod.GET, headers = { "Accept=application/json" })
	@ResponseStatus(HttpStatus.OK)
	public List<TestCdkModel> getUsers() {
		return testCdkService.getAll();
	}
	

	/**
	 * create new user
	 */
	@PostMapping("/testcdk")
	TestCdkModel createElement(@Valid @RequestBody TestCdkModel testCdkModel) {
		return testCdkService.create(testCdkModel);
	}

	
	
	
}
