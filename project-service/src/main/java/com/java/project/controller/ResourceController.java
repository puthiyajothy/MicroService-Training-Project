package com.java.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.project.model.ResourceAllocation;
import com.java.project.service.ResourceAllocationService;

@RestController
public class ResourceController {
	@Autowired
	private ResourceAllocationService resourceService;
	
	@RequestMapping(value="/saveresource" , method = RequestMethod.POST)
	public ResourceAllocation saveresource(@RequestBody ResourceAllocation resourceAllocation) {
		return resourceService.saveresource(resourceAllocation);
	}

}
