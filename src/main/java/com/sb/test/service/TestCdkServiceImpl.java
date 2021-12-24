package com.sb.test.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sb.test.exception.ResourceNotFoundException;
import com.sb.test.model.TestCdkModel;
import com.sb.test.repository.TestCdkRepository;

@Service
public class TestCdkServiceImpl implements TestCdkService{
	

	@Autowired
	private TestCdkRepository testCdkRepository;

	/* GET */
	public List<TestCdkModel> getAll() {
		return testCdkRepository.findAll();
	}

	/* GET by ID */
	public ResponseEntity<TestCdkModel> getById(int id) throws ResourceNotFoundException {
		TestCdkModel testCdkModel = testCdkRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + id));
		return ResponseEntity.ok().body(testCdkModel);
	}

	public TestCdkModel create(TestCdkModel testCdkModel) {
		return testCdkRepository.save(testCdkModel);
	}

//	public ResponseEntity<Employee> update(int id, Employee employee) throws ResourceNotFoundException {
//
//		Employee employee1 = testCdkRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
//
//		employee1.setFirst_name(employee.getFirst_name());
//		employee1.setLast_name(employee.getLast_name());
//		employee1.setEmail_id(employee.getEmail_id());
//
//		final Employee updatedUser = testCdkRepository.save(employee1);
//		return ResponseEntity.ok(updatedUser);
//	}

//	public Map<String, Boolean> delete(int id) throws ResourceNotFoundException {
//		Employee rn_users = testCdkRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
//
//		testCdkRepository.delete(rn_users);
//		Map<String, Boolean> response = new HashMap<>();
//		response.put("deleted", Boolean.TRUE);
//		return response;
//	}


}
