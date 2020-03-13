package com.java.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.project.model.SubModule;
import com.java.project.service.SubModuleService;

@RestController
public class SubModuleController {
	
	@Autowired
	private SubModuleService subService;
	
	@RequestMapping(value="/savesubmodule", method = RequestMethod.POST)
	public SubModule savesubmodule(@RequestBody SubModule submodule) {
		return subService.savesubmodule(submodule);
		
	}
	
	@RequestMapping(value="/listsubmodule", method = RequestMethod.GET)
	public List<SubModule>listsubmodule(){
		return subService.listsubmodule();
	}

}
