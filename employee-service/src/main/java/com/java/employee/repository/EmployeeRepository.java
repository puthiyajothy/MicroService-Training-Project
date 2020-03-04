package com.java.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
