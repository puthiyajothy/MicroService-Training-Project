package com.java.employee.service;

import java.util.List;

import com.java.employee.model.Employee;

public interface  EmployeeService {
	
	public Employee saveemployee (Employee employee);
	public List<Employee>listemployees();
	public Employee updateemployee(Employee employee);
	public Employee getEmployeeById(Integer id); 
	public Employee updateEmployee(Employee employee);
	public List<Employee> getByName(String name);
	public Employee getByEmail(String email);
	public void deleteEmployeeByempId(Long id);
	public List<Employee> getByDesignation(Long designationid);
	public long count();
	


	

}
