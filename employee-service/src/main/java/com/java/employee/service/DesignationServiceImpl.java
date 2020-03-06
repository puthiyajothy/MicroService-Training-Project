package com.java.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.employee.model.Designation;
import com.java.employee.repository.DesignationRepository;

@Service
public class DesignationServiceImpl implements DesignationService{
	@Autowired
	private DesignationRepository designationRepo;
	
	
	
	@Override
	public Designation savedesignation(Designation designation) {
		return designationRepo.save(designation);
	}



	@Override
	public List<Designation> listdesignation() {
		// TODO Auto-generated method stub
		return designationRepo.findAll();
	}

}
