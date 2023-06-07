package com.nic.employee.Entity;

//import java.sql.Date;
//import java.sql.Date;
//import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name= "employee")
public class Employee {
	@Id
	@Pattern(regexp = "^[A-Z]{3}[0-9]{3}$", message = "Invalid format the first three characters are alphabetic and the next three characters are numeric")
	private String id;
	
    @Pattern(regexp = "[a-zA-Z. ]+",message = "Invalid format Give the proper format of alphabetic")
	@Size(min = 3, max = 50,message = "The Name given was in the Invalid Format the length sholud be in between 3 and 50")
    @NotEmpty(message = "Employee name cannot be empty.")
	private String name;
	
    @NotBlank(message = "Please Provide the Gender") 
	private String gender;
	
    @NotNull(message = "Date of birth is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private String dob;
	
	@NotBlank(message = "Please Give The  Designation")
    @NotNull(message = "Please Give The  Designation")
	private String designation;
	
	@NotNull(message = "Please enter a valid salary")
    @Min(value=10000, message = "Salary must be atleast 10000")
	private long salary;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String date) {
		this.dob = date;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}
	

	

	
}

