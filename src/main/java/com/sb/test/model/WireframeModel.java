package com.sb.test.model;

import java.io.Serializable;
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

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Table(name = "ohwf_table")
public class WireframeModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ohwf_id", nullable = false)
	private int ohwf_id;
//	
//
//	@OneToMany(targetEntity = Wf_field_properties.class, cascade = CascadeType.ALL)
//	@JoinColumn(name="f_ohwf_id", referencedColumnName = "ohwf_id")
//	private List<Wf_field_properties> wf_field_properties;

//	public WireframeModel() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
	
	


//	public WireframeModel(int ohwf_id,String form_name,
//			String form_type, String table_name, String html_name, String css_name, String component_name,
//			String ts_service_name, String ts_model_name, String model_name, String repository_name,
//			String service_name, String service_impl_name, String controller_name) {
//		super();
//		this.ohwf_id = ohwf_id;
//		this.form_name = form_name;
//		this.form_type = form_type;
//		this.table_name = table_name;
//		this.html_name = html_name;
//		this.css_name = css_name;
//		this.component_name = component_name;
//		this.ts_service_name = ts_service_name;
//		this.ts_model_name = ts_model_name;
//		this.model_name = model_name;
//		this.repository_name = repository_name;
//		this.service_name = service_name;
//		this.service_impl_name = service_impl_name;
//		this.controller_name = controller_name;
//	}




	@Column(name = "form_name")
	private String form_name;

	@Column(name = "form_type")
	private String form_type;

	@Column(name = "table_name")
	private String table_name;

	@Column(name = "html_name")
	private String html_name;
	
	@Column(name = "css_name")
	private String css_name;

	@Column(name = "component_name")
	private String component_name;

	@Column(name = "ts_service_name")
	private String ts_service_name;

	@Column(name = "ts_model_name")
	private String ts_model_name;

	@Column(name = "model_name")
	private String model_name;

	@Column(name = "repository_name")
	private String repository_name;

	@Column(name = "service_name")
	private String service_name;

	@Column(name = "service_impl_name")
	private String service_impl_name;
	
	@Column(name = "controller_name")
	private String controller_name;

	public int getOhwf_id() {
		return ohwf_id;
	}

	public void setOhwf_id(int ohwf_id) {
		this.ohwf_id = ohwf_id;
	}

	public String getForm_name() {
		return form_name;
	}

	public void setForm_name(String form_name) {
		this.form_name = form_name;
	}

	public String getForm_type() {
		return form_type;
	}

	public void setForm_type(String form_type) {
		this.form_type = form_type;
	}

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	public String getHtml_name() {
		return html_name;
	}

	public void setHtml_name(String html_name) {
		this.html_name = html_name;
	}

	public String getCss_name() {
		return css_name;
	}

	public void setCss_name(String css_name) {
		this.css_name = css_name;
	}

	public String getComponent_name() {
		return component_name;
	}

	public void setComponent_name(String component_name) {
		this.component_name = component_name;
	}

	public String getTs_service_name() {
		return ts_service_name;
	}

	public void setTs_service_name(String ts_service_name) {
		this.ts_service_name = ts_service_name;
	}

	public String getTs_model_name() {
		return ts_model_name;
	}

	public void setTs_model_name(String ts_model_name) {
		this.ts_model_name = ts_model_name;
	}

	public String getModel_name() {
		return model_name;
	}

	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}

	public String getRepository_name() {
		return repository_name;
	}

	public void setRepository_name(String repository_name) {
		this.repository_name = repository_name;
	}

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public String getService_impl_name() {
		return service_impl_name;
	}

	public void setService_impl_name(String service_impl_name) {
		this.service_impl_name = service_impl_name;
	}

	public String getController_name() {
		return controller_name;
	}

	public void setController_name(String controller_name) {
		this.controller_name = controller_name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "WireframeModel [ohwf_id=" + ohwf_id + ", form_name=" + form_name + ", form_type=" + form_type
				+ ", table_name=" + table_name + ", html_name=" + html_name + ", css_name=" + css_name
				+ ", component_name=" + component_name + ", ts_service_name=" + ts_service_name + ", ts_model_name="
				+ ts_model_name + ", model_name=" + model_name + ", repository_name=" + repository_name
				+ ", service_name=" + service_name + ", service_impl_name=" + service_impl_name + ", controller_name="
				+ controller_name + "]";
	}

	
	


	
	
}
