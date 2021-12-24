package com.sb.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.test.model.Student;
import com.sb.test.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	/* ADD Records of Students */
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	/* GET Records of Students */
	public List<Student> getAll() {
		return studentRepository.findAll();
	}

}
