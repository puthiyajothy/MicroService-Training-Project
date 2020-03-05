package com.java.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.employee.model.Employee;
import com.java.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService{
	
	@Autowired
	private  EmployeeRepository empRepo;

	@Override
	public Employee saveemployee(Employee employee) {
		return empRepo.save(employee);
	}

	@Override
	public List<Employee> listemployees() {
		return empRepo.findAll();
	}
	
	
	

}
