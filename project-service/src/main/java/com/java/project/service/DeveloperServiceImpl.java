package com.java.project.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Developer findBydeveloperId(Integer id) {
		Optional<Developer> optionaldev = developerRepository.findById(id);
		if (optionaldev.isPresent()) {
			Developer developer = optionaldev.get();
			return developer;
		} else
			return null;
	}	

	@Override
	public void deletedeveloperById(Integer id) {
		developerRepository.deleteById(id);
	}

	@Override
	public void updatedeveloper(Developer developer) {
		// TODO Auto-generated method stub
		
	}

}
