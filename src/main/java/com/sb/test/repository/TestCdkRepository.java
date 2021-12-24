package com.sb.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.test.model.TestCdkModel;

@Repository
public interface TestCdkRepository extends JpaRepository<TestCdkModel, Integer>{

}
