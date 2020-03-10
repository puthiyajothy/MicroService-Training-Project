package com.java.project.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.java.project.model.Module;
import com.java.project.service.ModuleService;

@RestController
public class ModuleController {
	
	

	@Autowired
	private ModuleService moduleService;
	
	@SuppressWarnings("unused")
	private static Logger logger = LogManager.getLogger(ModuleController.class);

	@RequestMapping(value = "/savemodule", method = RequestMethod.POST)
	public Module savemodule(@RequestBody Module module) {
		return moduleService.savemodule(module);
	}

	@RequestMapping(value = "/listmodule", method = RequestMethod.GET)
	public List<Module> listmodule() {
		return moduleService.listmodule();
	}
	
}
