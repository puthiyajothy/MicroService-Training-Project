package com.java.project.service;

import java.util.List;

import com.java.project.model.ResourceAllocation;

public interface ResourceAllocationService {
	
//	<--Save Resource Allocation Method--->
	public ResourceAllocation saveresource (ResourceAllocation resourceAllocation);
	
	public List<ResourceAllocation> gettAllResource();
	
	public ResourceAllocation findbyid(Integer id);

    public List<ResourceAllocation> getresourceById();
    
	public ResourceAllocation getEmployee(Integer id);
	
//  <---save Resource Allocation Bulk Date--->
	void saveResourceTable(List<ResourceAllocation> resourceAllocation);
	
//<--- Resource Allocation Delete  Method--->
	public ResourceAllocation deleteResourceById(Long resourceId);

//	public List<ResourceAllocation> findByEmployeebyid(Integer id);
	

}
