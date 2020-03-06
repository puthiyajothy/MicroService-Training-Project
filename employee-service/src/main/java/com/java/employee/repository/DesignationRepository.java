package com.java.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.employee.model.Designation;

public interface DesignationRepository extends JpaRepository<Designation, Integer>{

}
