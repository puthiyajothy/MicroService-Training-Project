package com.java.project.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.project.model.Developer;
import com.java.project.model.Project;
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
	
	@RequestMapping(value = "/listdeveloperby/{id}", method = RequestMethod.GET)
	public Developer getdeveloper(@PathVariable Integer id) {
		return developerService.findBydeveloperId(id);
	}

	@RequestMapping(value = "/deletedev/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteProject(@PathVariable("id") Integer id) {
	try {
		logger.info("Developer Controller :-> DeleteDeveloperById");
		developerService.deletedeveloperById(id);
		return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
	} catch (Exception ex) {
		logger.error("Developer Controller :-> Error" + ex.getMessage());
	}
	return null;
}


}
