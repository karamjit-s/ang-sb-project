package com.sb.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.test.model.WireframeModel;

@Repository
public interface WireframeRepository extends JpaRepository<WireframeModel, Integer> {

	

}