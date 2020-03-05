package com.java.employee.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Employee updateemployee(Employee employee) {
		return empRepo.save(employee);
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		Optional<Employee> optionalEmployee =empRepo.findById(id);
		if (optionalEmployee.isPresent()) {
			Employee employee = optionalEmployee.get();
			return employee;
		} else
			return null;
	}

	
	
	

}
