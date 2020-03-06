package com.java.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.project.model.Project;
import com.java.project.repository.ProjectRepository;
import com.java.project.service.ProjectService;

@RestController
public class ProjectController {

	
	@Autowired
//	private ProjectService projectservice;
	private ProjectRepository projectrepo;
	
	
	@RequestMapping(value = "/savedproject", method = RequestMethod.POST)
	public Project saveproject(@RequestBody Project project) {
//		return projectservice.saveproject(project);
		return projectrepo.save(project);
	}

	
	@RequestMapping(value = "/listproject", method = RequestMethod.GET)
	public List<Project> listproject() {
		return projectrepo.findAll();
	}

}

