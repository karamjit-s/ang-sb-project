package com.sb.test.service;

import java.util.List;
import com.sb.test.model.TestCdkModel;

public interface TestCdkService {
	
	/* GET */
	public List<TestCdkModel> getAll();

//	/* GET by ID */
//	public ResponseEntity<Employee> getById(int id) throws ResourceNotFoundException;

	/* CREATE */
	public TestCdkModel create(TestCdkModel testCdkModel);
	
//
//	/* UPDATE */
//	public ResponseEntity<Employee> update(int id, Employee employee) throws ResourceNotFoundException;
//
//	/* DELETE */
//	public Map<String, Boolean> delete(int id) throws ResourceNotFoundException;


}
