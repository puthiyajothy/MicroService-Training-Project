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
		return resourceRepo.findAll();
	}

	@Override
	public ResourceAllocation findResourceAllocationByresourceId(Integer resourceId) {
		return resourceRepo.findResourceAllocationByresourceId(resourceId);
	}

	@Override
	public List<ResourceAllocation> getresourceById() {
		return resourceRepo.getAllresourceId();
	}

}
