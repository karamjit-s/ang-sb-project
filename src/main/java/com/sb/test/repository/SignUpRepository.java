package com.sb.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.test.model.SignUpModel;

@Repository
public interface SignUpRepository extends JpaRepository<SignUpModel, Integer> {

}
