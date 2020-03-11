package com.java.project.service;

import java.util.List;

import com.java.project.model.ResourceAllocation;

public interface ResourceAllocationService {
	
	public ResourceAllocation saveresource (ResourceAllocation resourceAllocation);
	
	public List<ResourceAllocation> gettAllResource();
	
	public ResourceAllocation findResourceAllocationByresourceId(Integer resourceId);

    public List<ResourceAllocation> getresourceById();
    
	public List<ResourceAllocation> findByEmployeebyid(Integer id);

}
