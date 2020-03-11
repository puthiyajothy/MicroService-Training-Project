package com.java.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.project.model.ResourceAllocation;
import com.java.project.repository.ResourceAllocationRepository;

@Service
public class ResourceAllocationServiceImpl implements ResourceAllocationService {
	@Autowired
	private ResourceAllocationRepository resourceRepo;

	@Override
	public ResourceAllocation saveresource(ResourceAllocation resourceAllocation) {
		return resourceRepo.save(resourceAllocation) ;
	}

	@Override
	public List<ResourceAllocation> gettAllResource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResourceAllocation findResourceAllocationByresourceId(Long resourceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResourceAllocation> getresourceById() {
		// TODO Auto-generated method stub
		return null;
	}

}
