package com.java.project.service;

import java.util.List;

import com.java.project.model.ResourceAllocation;

public interface ResourceAllocationService {
	
	public ResourceAllocation saveresource (ResourceAllocation resourceAllocation);
	
	public List<ResourceAllocation> gettAllResource();
	
	public ResourceAllocation findbyid(Integer id);

    public List<ResourceAllocation> getresourceById();
    
	public ResourceAllocation getEmployee(Integer id);

//	public List<ResourceAllocation> findByEmployeebyid(Integer id);
	

}
