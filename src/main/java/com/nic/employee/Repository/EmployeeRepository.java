package com.nic.employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nic.employee.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    
}
