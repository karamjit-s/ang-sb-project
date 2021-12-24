package com.sb.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.test.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
