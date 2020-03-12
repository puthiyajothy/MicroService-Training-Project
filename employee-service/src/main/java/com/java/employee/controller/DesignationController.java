package com.java.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.java.employee.model.Designation;
import com.java.employee.service.DesignationService;

@RestController
public class DesignationController {

	@Autowired
	private DesignationService designationService;

	@RequestMapping(value = "/savedesignation", method = RequestMethod.POST)
	public Designation saveemployee(@RequestBody Designation designation) {
		return designationService.savedesignation(designation);
	}

	@RequestMapping(value = "/listdesignation", method = RequestMethod.GET)
	public List<Designation> listemployees() {
		return designationService.listdesignation();
	}
}
