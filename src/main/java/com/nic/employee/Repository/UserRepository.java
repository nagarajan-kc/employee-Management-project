package com.nic.employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nic.employee.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    
//	 User findByUsernameAndPassword(String username, String password);

	User findByUsername(String username);
	 
}