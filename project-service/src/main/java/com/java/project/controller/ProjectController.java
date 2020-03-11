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

import com.java.project.model.Project;
import com.java.project.repository.ProjectRepository;
import com.java.project.service.ProjectService;

@RestController
public class ProjectController {

	
	private static Logger logger = LogManager.getLogger(ProjectController.class);

	
	@Autowired
	private ProjectService projectservice;
//	private ProjectRepository projectrepo;
	
	
	@RequestMapping(value = "/savedproject", method = RequestMethod.POST)
	public Project saveproject(@RequestBody Project project) {
//		return projectservice.saveproject(project);
		return projectservice.saveproject(project);
	}

	
	
	@RequestMapping(value = "/listproject", method = RequestMethod.GET)
	public List<Project> listproject() {
		return projectservice.listproject();
	}

	@RequestMapping(value = "/listprojectby/{id}", method = RequestMethod.GET)
	public Project getproject(@PathVariable Integer id) {
		return projectservice.FindById(id);
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateproject(@RequestBody Project project) {
		try {
			
			if(projectservice.updateproject(project)!=null) {
				return new ResponseEntity<>("Successfully Updates", HttpStatus.OK);
			}
			return new ResponseEntity<>("Update Failed", HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("Project Controller :-> Error" + ex.getMessage());
		}
		return null;
	}
	
	@RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE) 
	public ResponseEntity<String> deleteProject(@PathVariable("id") Integer id) {
		try {
			logger.info("Project Controller :-> DeleteProjectById");
			projectservice.deleteprojectById(id);
			return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("Employee Controller :-> Error" + ex.getMessage());
		}
		return null;
	}

}

