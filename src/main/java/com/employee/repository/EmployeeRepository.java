package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entity.EmployeeDetails;

import jakarta.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Integer>{
EmployeeDetails findByEmpemailid(String empemailid);
@Transactional
int removeByEmpemailid(String empemailid);
}
