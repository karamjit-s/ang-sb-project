package com.sb.test.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id", nullable = false)
	private int student_id;

	@OneToMany(targetEntity = Projects.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "student_fk", referencedColumnName = "student_id")
	private List<Projects> products;

	@Column(name = "student_name", nullable = false)
	private String student_name;

	@Column(name = "college_name", nullable = false)
	private String college_name;

	@Column(name = "department", nullable = false)
	private String department;

	@Column(name = "email_id", nullable = false)
	private String email_id;

	@Column(name = "roll_no", nullable = false)
	private long roll_no;

}
