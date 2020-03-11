package com.java.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.project.model.ResourceAllocation;

public interface ResourceAllocationRepository extends JpaRepository<ResourceAllocation, Integer>{

	ResourceAllocation findResourceAllocationByresourceId(Integer resourceId);
	String fetchAllresourceId = "SELECT resource_id FROM resource_allocation";
	@Query(value = fetchAllresourceId, nativeQuery=true)
	<T> List<T> getAllresourceId();


}
