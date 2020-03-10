package com.java.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.project.model.Developer;
import com.java.project.repository.DeveloperRepository;

@Service
public class DeveloperServiceImpl implements DeveloperService{
	
	@Autowired
	private DeveloperRepository developerRepository;

	@Override
	public Developer savedeveloper(Developer developer) {
		return developerRepository.save(developer);
	}

	@Override
	public List<Developer> listdeveloper() {
		return developerRepository.findAll();
	}

}
