package com.nic.employee.Entity;

import jakarta.persistence.Column;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "users")
public class User {
    
	@Id
	private String id;
	@Column
	private String username;
	@Column
	 private String password;
	 
	
	 public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
	  return username;
	 }
	 public void setUsername(String username) {
	  this.username = username;
	 }
	 public String getPassword() {
	  return password;
	 }
	 public void setPassword(String password) {
	  this.password = password;
	 }
	

	 private String encodePassword(String password) {
	        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        return passwordEncoder.encode(password);
	    }

	    public boolean matchesPassword(String password) {
	        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        return passwordEncoder.matches(password, password);
	    }
}