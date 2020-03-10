package com.java.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.project.model.Module;
import com.java.project.repository.ModuleRepository;

@Service
public class ModuleServiceImpl implements ModuleService {
	@Autowired
	private ModuleRepository moduleRepo;

	@Override
	public Module savemodule(Module module) {
				return moduleRepo.save(module);
	}

	@Override
	public List<Module> listmodule() {
		return moduleRepo.findAll();
	}

}
