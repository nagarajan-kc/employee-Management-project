package com.nic.employee.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.nic.employee.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String>{

//	@Query("Select employee.id,employee.name,employee.dob,employee.gender,employee.salary,designation.field From employee Join designation ON employee.designation = designation.code")
//	List<Employee> getAllEmployees();
	

//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    String JOIN_QUERY = "Select employee.id,employee.name,employee.dob,employee.gender,employee.salary,designation.field From employee Join designation ON employee.designation = designation.code";
    // System.out.println(JOIN_QUERY);

//    public static List<Employee> getTestData() {
//        return jdbcTemplate.query(JOIN_QUERY, new BeanPropertyRowMapper<Employee>(Employee.class));
//    }
}
