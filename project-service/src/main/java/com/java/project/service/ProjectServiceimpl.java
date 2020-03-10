package com.java.project.service;

import java.util.List;
import java.util.Optional;
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


	@Override
	public Project FindById(Integer id) {
		Optional<Project> optionalproject = projectRepo.findById(id);
		if (optionalproject.isPresent()) {
			Project project = optionalproject.get();
			return project;
		} else
			return null;
	}


	@Override
	public Project updateproject(Project Project) {
		 return projectRepo.save(Project);		
	}


	@Override
	public void deleteprojectById(Integer id) {
		projectRepo.deleteById(id);
	}

}
