package com.java.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.project.model.RoleAllocation;

public interface RoleAllocationRepository extends JpaRepository<RoleAllocation, Integer>{

}
