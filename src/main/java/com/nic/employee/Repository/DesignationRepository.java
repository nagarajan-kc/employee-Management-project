package com.nic.employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nic.employee.designation.Designation;

@Repository
public interface DesignationRepository extends JpaRepository<Designation, String> {

}
