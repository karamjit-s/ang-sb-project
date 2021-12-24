package com.sb.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.test.model.Wf_field_properties;

@Repository
public interface WF_fp_repository extends JpaRepository<Wf_field_properties, Integer>{

}
