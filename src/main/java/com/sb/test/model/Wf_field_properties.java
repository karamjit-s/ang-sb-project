package com.sb.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
@Table(name = "wf_p_t")
public class Wf_field_properties {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wf_p_id", nullable = false)
	private int wf_p_id;

	
//	public Wf_field_properties() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

	@Column(name = "foreign_key")
	private int foreign_key;
	
	@Column(name = "key1")
	private String key1;

	@Column(name = "field_name")
	private String field_name;

	@Column(name = "field_type")
	private String field_type;

	@Column(name = "field_data_type")
	private String field_data_type;

	@Column(name = "mapping")
	private String mapping;

	@Column(name = "sequence")
	private int sequence;

	@Column(name = "section_no")
	private int section_no;


	public int getWf_p_id() {
		return wf_p_id;
	}

	public void setWf_p_id(int wf_p_id) {
		this.wf_p_id = wf_p_id;
	}

	public int getForeign_key() {
		return foreign_key;
	}

	public void setForeign_key(int foreign_key) {
		this.foreign_key = foreign_key;
	}

	public String getKey1() {
		return key1;
	}

	public void setKey1(String key1) {
		this.key1 = key1;
	}

	public String getField_name() {
		return field_name;
	}

	public void setField_name(String field_name) {
		this.field_name = field_name;
	}

	public String getField_type() {
		return field_type;
	}

	public void setField_type(String field_type) {
		this.field_type = field_type;
	}

	public String getField_data_type() {
		return field_data_type;
	}

	public void setField_data_type(String field_data_type) {
		this.field_data_type = field_data_type;
	}

	public String getMapping() {
		return mapping;
	}

	public void setMapping(String mapping) {
		this.mapping = mapping;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public int getSection_no() {
		return section_no;
	}

	public void setSection_no(int section_no) {
		this.section_no = section_no;
	}

	
	

}


