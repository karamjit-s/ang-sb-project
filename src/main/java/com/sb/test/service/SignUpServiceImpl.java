package com.sb.test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sb.test.exception.ResourceNotFoundException;
import com.sb.test.model.SignUpModel;
import com.sb.test.repository.SignUpRepository;

@Service
public class SignUpServiceImpl implements SignUpService {

	@Autowired
	private SignUpRepository signUpRepository;

	/* GET */
	public List<SignUpModel> getAll() {
		return signUpRepository.findAll();
	}

	/* GET by ID */
	public ResponseEntity<SignUpModel> getById(int id) throws ResourceNotFoundException {
		SignUpModel signUpModel = signUpRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Signup User not found on :: " + id));
		return ResponseEntity.ok().body(signUpModel);
	}

	public SignUpModel create(SignUpModel signUpModel) {
		return signUpRepository.save(signUpModel);
	}

	public ResponseEntity<SignUpModel> update(int id, SignUpModel signUpModel) throws ResourceNotFoundException {

		SignUpModel signUpModel1 = signUpRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Signup data not found for this id :: " + id));

		signUpModel1.setFirst_name(signUpModel.getFirst_name());
		signUpModel1.setLast_name(signUpModel.getLast_name());
		signUpModel1.setUser_name(signUpModel.getUser_name());
		signUpModel1.setEmail_id(signUpModel.getEmail_id());
		signUpModel1.setPassword(signUpModel.getPassword());
		signUpModel1.setConfirm_password(signUpModel.getConfirm_password());

		final SignUpModel signUpModelUpdateUSer = signUpRepository.save(signUpModel1);
		return ResponseEntity.ok(signUpModelUpdateUSer);
	}

	public Map<String, Boolean> delete(int id) throws ResourceNotFoundException {
		SignUpModel signUpUsers = signUpRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Signup data not found for this id :: " + id));

		signUpRepository.delete(signUpUsers);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
