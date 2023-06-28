package com.nic.employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nic.employee.Entity.HistoryOfEmployee;

@Repository
public interface EmployeeHistoryRepository extends JpaRepository<HistoryOfEmployee, String> {

}
