package com.java.project.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.project.model.Developer;
import com.java.project.service.DeveloperService;

@RestController
public class DeveloperController {
	@Autowired
	private DeveloperService developerService;
	
	@SuppressWarnings("unused")
	private static Logger logger = LogManager.getLogger(DeveloperController.class);

	
	@RequestMapping(value = "/savedeveloper", method = RequestMethod.POST)
	public Developer savedeveloper(@RequestBody Developer developer) {
		return developerService.savedeveloper(developer);
	}

	@RequestMapping(value = "/listdeveloper", method = RequestMethod.GET)
	public List<Developer> listdeveloper() {
		return developerService.listdeveloper();
	}

}
