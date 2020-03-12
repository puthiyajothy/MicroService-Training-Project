package com.java.project.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.project.model.ResourceAllocation;
import com.java.project.service.ResourceAllocationService;

@RestController
public class ResourceAllocationController {
	@Autowired
	private ResourceAllocationService resourceService;
	@SuppressWarnings("unused")
	private static Logger logger = LogManager.getLogger(ResourceAllocationController.class);

	
	@RequestMapping(value="/saveresource" , method = RequestMethod.POST)
	public ResourceAllocation saveresource(@RequestBody ResourceAllocation resourceAllocation) {
		return resourceService.saveresource(resourceAllocation);
	}

	@RequestMapping(value = "/listresource",method = RequestMethod.GET)
	public List<ResourceAllocation> listresource(){
		return resourceService.gettAllResource();
		
	}
	
	 @RequestMapping(value = "/listresourceby/{id}",method = RequestMethod.GET)
		public ResourceAllocation listresourcebyid(@PathVariable("resourceId") Integer id) {
			return resourceService.findbyid(id);

	}
	 

	 @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
		public ResourceAllocation getEmployeebyid(@PathVariable Integer id) {
			return resourceService.getEmployee(id);
		}
	 
	 

	 
	}
