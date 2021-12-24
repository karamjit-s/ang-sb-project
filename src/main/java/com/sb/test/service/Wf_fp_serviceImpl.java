package com.sb.test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sb.test.exception.ResourceNotFoundException;
import com.sb.test.model.Wf_field_properties;
import com.sb.test.repository.WF_fp_repository;

@Service
public class Wf_fp_serviceImpl implements Wf_fp_service{

	@Autowired
	WF_fp_repository wf_fp_repository;
	
	
	
	/* GET */
	public List<Wf_field_properties> getAll() {
		return wf_fp_repository.findAll();
	}

	/* GET by ID */
	public ResponseEntity<Wf_field_properties> getById(int id) throws ResourceNotFoundException {
		Wf_field_properties wf_field_properties = wf_fp_repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + id));
		return ResponseEntity.ok().body(wf_field_properties);
	}

	
//	public Wf_field_properties create(Wf_field_properties wf_field_properties) {
//		
////		
////		/* field properties for primary id */
////		{
////		Wf_field_properties wf_field_properties2 =new Wf_field_properties();
////		wf_field_properties2.setForeign_key(foreign_key);
////		wf_field_properties2.setField_name("id");
////		wf_field_properties2.setMapping("id");
////		wf_field_properties2.setField_type("id");
////		wf_field_properties2.setField_data_type("int");
////		wf_field_properties2.setKey1("primary");
////		wf_field_properties2.setSection_no(1);
////		wf_field_properties2.setSequence(0);
////		
////		wf_fp_repository.save(wf_field_properties2);
////		
////		}
////		
////		/* field properties for section */
////		{
////		Wf_field_properties wf_field_properties3 =new Wf_field_properties();
////
////		wf_field_properties3.setField_name("Section");
////		wf_field_properties3.setMapping("section");
////		wf_field_properties3.setField_type("section");
////		wf_field_properties3.setField_data_type("N");
////		wf_field_properties3.setKey1("N");
////		wf_field_properties3.setSection_no(1);
////		wf_field_properties3.setSequence(0);
////		
////		wf_fp_repository.save(wf_field_properties3);
////		}
////		
////		/* field properties for default 4 textfields  */
////
////		
////		for(int i=1;i<=4;i++)
////		{
////			Wf_field_properties wf_field_properties4 = new Wf_field_properties();
////			
////			wf_field_properties4.setField_name("Textfield "+i);
////			wf_field_properties4.setMapping("textfield_"+i);
////			wf_field_properties4.setField_type("textfield");
////			wf_field_properties4.setField_data_type("varchar");
////			wf_field_properties4.setKey1("N");
////			wf_field_properties4.setSection_no(1);
////			wf_field_properties4.setSequence(i);
////
////			wf_fp_repository.save(wf_field_properties4);
////
////		}
////
////		
////		
////		/* field properties for button */
////		Wf_field_properties wf_field_propertie5 = new Wf_field_properties();
////
////		{
////			
////			wf_field_propertie5.setField_name("Submit");
////			wf_field_propertie5.setMapping("submit_button");
////			wf_field_propertie5.setField_type("button");
////			wf_field_propertie5.setField_data_type("N");
////			wf_field_propertie5.setKey1("N");
////			wf_field_propertie5.setSection_no(0);
////			wf_field_propertie5.setSequence(0);
////		
////		}
//		
//		return wf_fp_repository.save(wf_field_propertie5);
//		
//		
//		
//		
//	}

	
	
	public ResponseEntity<Wf_field_properties> update(int id, Wf_field_properties wf_field_properties) throws ResourceNotFoundException {

		Wf_field_properties wf_field_properties1 = wf_fp_repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Wf_field_properties not found for this id :: " + id));

		wf_field_properties1.setField_name(wf_field_properties.getField_name());
		wf_field_properties1.setMapping(wf_field_properties.getMapping());
		wf_field_properties1.setField_type(wf_field_properties.getField_type());
		wf_field_properties1.setField_data_type(wf_field_properties.getField_data_type());
		wf_field_properties1.setKey1(wf_field_properties.getKey1());
		wf_field_properties1.setSection_no(wf_field_properties.getSection_no());
		wf_field_properties1.setSequence(wf_field_properties.getSequence());





		final Wf_field_properties updatedUser = wf_fp_repository.save(wf_field_properties1);
		return ResponseEntity.ok(updatedUser);
	}

	public Map<String, Boolean> delete(int id) throws ResourceNotFoundException {
		Wf_field_properties rn_users = wf_fp_repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Wf_field_properties not found for this id :: " + id));

		wf_fp_repository.delete(rn_users);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	
}
