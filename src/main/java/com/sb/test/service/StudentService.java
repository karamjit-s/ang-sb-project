package com.sb.test.service;

import java.util.List;

import com.sb.test.model.Student;

public interface StudentService {
	/* GET */
	public List<Student> getAll();

	/* ADD */
	public Student save(Student student);

}
