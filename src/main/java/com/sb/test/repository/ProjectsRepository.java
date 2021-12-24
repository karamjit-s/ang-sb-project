package com.sb.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.test.model.Projects;

@Repository
public interface ProjectsRepository extends JpaRepository<Projects, Integer> {

}
