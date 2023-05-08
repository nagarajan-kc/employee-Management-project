package com.nic.employee.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nic.employee.Entity.Employee;
import com.nic.employee.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List < Employee > getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
       this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
       Optional < Employee > optional = employeeRepository.findById(id);
       Employee employee = null;
       if (optional.isPresent()) {
           employee = optional.get();
            } else {
       throw new RuntimeException(" Employee not found for id :: " + id);
       }
            return employee;
}

    @Override
    public void deleteEmployeeById(int id) {
       this.employeeRepository.deleteById(id);
}
}
