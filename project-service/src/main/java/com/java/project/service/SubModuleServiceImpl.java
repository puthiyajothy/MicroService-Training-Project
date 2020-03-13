package com.java.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.project.model.SubModule;
import com.java.project.repository.SubmoduleRepository;

@Service
public class SubModuleServiceImpl implements SubModuleService{
	
	@Autowired
	private SubmoduleRepository subModuleRepo;

	@Override
	public SubModule savesubmodule(SubModule subModule) {
		return subModuleRepo.save(subModule);
	}

	@Override
	public List<SubModule> listsubmodule() {
		return subModuleRepo.findAll();
	}

}
