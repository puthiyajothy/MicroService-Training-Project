package com.java.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.project.model.ResourceAllocation;

public interface ResourceAllocationRepository extends JpaRepository<ResourceAllocation, Integer>{

}
