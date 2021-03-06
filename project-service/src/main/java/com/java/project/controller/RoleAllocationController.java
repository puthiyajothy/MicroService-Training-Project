package com.java.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.project.model.Project;
import com.java.project.model.RoleAllocation;
import com.java.project.repository.RoleAllocationRepository;
import com.java.project.service.RoleAllocationService;

@RestController
public class RoleAllocationController {
	
	@Autowired
	private RoleAllocationService roleService;
	
	
	
	
	@RequestMapping(value="/saverole",method = RequestMethod.POST)
	public RoleAllocation saverole(@RequestBody RoleAllocation role) {
		return roleService.saverole(role);
	}
		
	@RequestMapping(value = "/listrole", method = RequestMethod.GET)
	public List<RoleAllocation> listRole() {
		return roleService.listrole();
	}
}
