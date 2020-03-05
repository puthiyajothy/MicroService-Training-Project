package com.java.employee.service;

import java.util.List;

import com.java.employee.model.Employee;

public interface  EmployeeService {
	
	public Employee saveemployee (Employee employee);
	public List<Employee>listemployees();
	public Employee updateemployee(Employee employee);
	public Employee getEmployeeById(Integer id); 

	
	

}
