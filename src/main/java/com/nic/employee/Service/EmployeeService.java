package com.nic.employee.Service;

import java.util.List;

import com.nic.employee.Entity.Employee;
import com.nic.employee.Entity.User;
import com.nic.employee.designation.Designation;

public interface EmployeeService {
	 List<Employee> getAllEmployees();
	    
	 void saveEmployee(Employee employee );

	    Employee getEmployeeById(String id);

	    int deleteEmployeeById(String id);
	    
	    List<Designation> getAllDesignation() ;

		List<Designation> findAll();

		void save(User user);
		
}
