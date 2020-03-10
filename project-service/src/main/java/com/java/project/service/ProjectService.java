package com.java.project.service;

import java.util.List;

import com.java.project.model.Project;

public interface ProjectService {

	public Project saveproject (Project project);
	public List<Project>listproject();
	public Project FindById(Integer id);
	public Project updateproject(Project Project);
	public void deleteprojectById(Integer id);
}
