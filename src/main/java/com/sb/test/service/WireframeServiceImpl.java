package com.sb.test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sb.test.exception.ResourceNotFoundException;
import com.sb.test.model.Wf_field_properties;
import com.sb.test.model.WireframeModel;
import com.sb.test.repository.WF_fp_repository;
import com.sb.test.repository.WireframeRepository;

@Service
public class WireframeServiceImpl implements WireframeService {

	@Autowired
	WireframeRepository ohwfRepository;

	@Autowired
	WF_fp_repository wf_fp_repository;

	/** GET */
	public List<WireframeModel> getAll() {
		return ohwfRepository.findAll();
	}

	/** GET by ID */
	public ResponseEntity<WireframeModel> getById(int id) throws ResourceNotFoundException {
		WireframeModel ohwfModel = ohwfRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ohwfModel not found on ohwf_id :: " + id));
		return ResponseEntity.ok().body(ohwfModel);
	}

	/**
	 * create values for wireframe
	 * 
	 * @return
	 */

	public WireframeModel create(WireframeModel wireframeModel) {

		ohwfRepository.save(wireframeModel);

		String form_name = wireframeModel.getForm_name();
		System.out.println("form_name in create method of OhwfServiceImpl class is  == " + form_name);

		int ohwf_id = wireframeModel.getOhwf_id();
		String form_type = wireframeModel.getForm_type();
		String table_name = wireframeModel.getTable_name();

		wireframeModel.setForm_name(form_name);
		wireframeModel.setForm_type(form_type);
		wireframeModel.setTable_name(table_name);

		wireframeModel.setHtml_name(form_name.concat("_html"));
		wireframeModel.setCss_name(form_name.concat("_css"));
		wireframeModel.setTs_service_name(form_name.concat("_ts_service"));
		wireframeModel.setTs_model_name(form_name.concat("_ts_model"));
		wireframeModel.setComponent_name(form_name.concat("_component"));

		wireframeModel.setModel_name(form_name.concat("_model"));
		wireframeModel.setRepository_name(form_name.concat("_repository"));
		wireframeModel.setService_name(form_name.concat("_service"));
		wireframeModel.setService_impl_name(form_name.concat("_serviceImpl"));
		wireframeModel.setController_name(form_name.concat("_controller"));

		/* field properties */
		/* field properties for primary id */
	

			Wf_field_properties wf_field_properties2 = new Wf_field_properties();
			wf_field_properties2.setForeign_key(ohwf_id);
			wf_field_properties2.setField_name("id");
			wf_field_properties2.setMapping("id");
			wf_field_properties2.setField_type("id");
			wf_field_properties2.setField_data_type("int");
			wf_field_properties2.setKey1("primary");
			wf_field_properties2.setSection_no(1);
			wf_field_properties2.setSequence(0);

			wf_fp_repository.save(wf_field_properties2);

		

		/* field properties for section */

		Wf_field_properties wf_field_properties3 = new Wf_field_properties();

		wf_field_properties3.setForeign_key(ohwf_id);
		wf_field_properties3.setField_name("Section");
		wf_field_properties3.setMapping("section");
		wf_field_properties3.setField_type("section");
		wf_field_properties3.setField_data_type("N");
		wf_field_properties3.setKey1("N");
		wf_field_properties3.setSection_no(1);
		wf_field_properties3.setSequence(0);

		wf_fp_repository.save(wf_field_properties3);

		/* field properties for default 4 textfields */

		for (int i = 1; i <= 4; i++) {
			Wf_field_properties wf_field_properties4 = new Wf_field_properties();

			wf_field_properties4.setForeign_key(ohwf_id);
			wf_field_properties4.setField_name("Textfield " + i);
			wf_field_properties4.setMapping("textfield_" + i);
			wf_field_properties4.setField_type("textfield");
			wf_field_properties4.setField_data_type("varchar");
			wf_field_properties4.setKey1("N");
			wf_field_properties4.setSection_no(1);
			wf_field_properties4.setSequence(i);

			wf_fp_repository.save(wf_field_properties4);

		}

		/* field properties for button */
		Wf_field_properties wf_field_propertie5 = new Wf_field_properties();

		wf_field_propertie5.setForeign_key(ohwf_id);
		wf_field_propertie5.setField_name("Submit");
		wf_field_propertie5.setMapping("submit_button");
		wf_field_propertie5.setField_type("button");
		wf_field_propertie5.setField_data_type("N");
		wf_field_propertie5.setKey1("N");
		wf_field_propertie5.setSection_no(0);
		wf_field_propertie5.setSequence(0);

		return ohwfRepository.save(wireframeModel);
	}

	/**
	 * update values for wireframe
	 * 
	 * @return
	 */
	public ResponseEntity<WireframeModel> update(int id, WireframeModel ohwfModel) throws ResourceNotFoundException {

		WireframeModel ohwfModel1 = ohwfRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("OhwfModel not found for this ohwf_id :: " + id));

		ohwfModel1.setForm_name(ohwfModel.getForm_name());
		ohwfModel1.setForm_type(ohwfModel.getForm_type());
		ohwfModel1.setTable_name(ohwfModel.getTable_name());

		final WireframeModel updatedUser = ohwfRepository.save(ohwfModel1);
		return ResponseEntity.ok(updatedUser);
	}

	/**
	 * delete values for wireframe
	 * 
	 * @return
	 */
	public Map<String, Boolean> delete(int id) throws ResourceNotFoundException {
		WireframeModel ohwfModel = ohwfRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("OhwfModel not found for this ohwf_id :: " + id));

		ohwfRepository.delete(ohwfModel);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
