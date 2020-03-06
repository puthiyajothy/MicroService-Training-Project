package com.java.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.project.model.Project;
import com.java.project.repository.ProjectRepository;
@Service
public class ProjectServiceimpl implements ProjectService{
	@Autowired
	private ProjectRepository projectRepo;
	

	@Override
	public Project saveproject(Project project) {
		return projectRepo.save(project);
	}


	@Override
	public List<Project> listproject() {
		return projectRepo.findAll();
	}

}
