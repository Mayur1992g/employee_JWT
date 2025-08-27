package com.emp.employee.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee{



	public Employee(){
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String employeeName;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String profile;
}
