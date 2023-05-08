package com.nic.employee.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name= "employee")
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column 
	private String gender;
	
	@Column 
	private Date dob;
	
	@Column
	private String designation;
	
	@Column 
	private long salary;
}

