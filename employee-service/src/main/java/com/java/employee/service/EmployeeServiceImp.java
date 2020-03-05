package com.java.employee.service;

import org.springframework.stereotype.Service;

import com.java.employee.model.Employee;
import com.java.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService{
	
	private  EmployeeRepository empRepo;

	@Override
	public Employee saveemployee(Employee employee) {
		// TODO Auto-generated method stub
		return empRepo.save(employee);
	}
	
	
	

}
