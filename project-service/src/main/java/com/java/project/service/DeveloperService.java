package com.java.project.service;

import java.util.List;

import com.java.project.model.Developer;

public interface DeveloperService {
	public Developer savedeveloper (Developer developer);
	public List<Developer> listdeveloper();
	public Developer findBydeveloperId(Integer id);
	public void deletedeveloperById(Integer id);
	public void updatedeveloper(Developer developer);


}
