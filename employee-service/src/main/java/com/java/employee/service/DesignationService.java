package com.java.employee.service;

import java.util.List;

import com.java.employee.model.Designation;

public interface DesignationService {
	
	public Designation savedesignation(Designation designation);
	public List<Designation>listdesignation();

}
