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


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Table(name = "test_cdk_table")
public class TestCdkModel {
	


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "test_cdk_id", nullable = false)
		private int cid;

		@Column(name = "element_name", nullable = false)
		private String element_name;
		
		
		
		

}
