package com.sb.test.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.test.model.Student;
import com.sb.test.service.StudentService;

@RestController
@CrossOrigin(origins = "http://localhost:4201")
@RequestMapping("/api/s1")
public class StudentController {

	@Autowired
	private StudentService studentService;

//	@Autowired
//	private StudentRepository studentRepository;
//	
//	@Autowired
//	private ProjectsRepository projectsRepository;
//	

	/**
	 * create new user
	 */
	@PostMapping("/students")
	Student addUser(@Valid @RequestBody Student student) {
		return studentService.save(student);
	}

	/**
	 * Get All users.
	 */
	@GetMapping("/students")
	public List<Student> getUsers() {
		return studentService.getAll();
	}

	/**
	 * Create Lines
	 */
//		@PostMapping("/students/{student_id}/projects")
//		public Projects createProjectsLines(@PathVariable(value = "student_id") Integer student_id,
//				@Valid @RequestBody Projects projectsLines ) throws ResourceNotFoundException {
//			return Student.findById(student_id).map(rn_hl_header_t -> {
//				rn_hl_line_t.setRn_hl_header_t(rn_hl_header_t);
//				return rn_hl_line_repository.save(rn_hl_line_t);
//			}).orElseThrow(() -> new ResourceNotFoundException("rn_hl_header_t not found"));
//		}
//	

}
