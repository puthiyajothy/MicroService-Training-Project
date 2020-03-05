package com.java.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.employee.model.Employee;
import com.java.employee.repository.EmployeeRepository;
import com.java.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
//	private EmployeeRepository empRepo;
	
	
	@RequestMapping(value = "/saveemployee", method = RequestMethod.POST)
	public Employee saveemployee(@RequestBody Employee employee) {
		return empService.saveemployee(employee);
	}

	@RequestMapping(value = "/listemployee", method = RequestMethod.GET)
	public List<Employee> listemployees() {
		return empService.listemployees();
	}
	
	@RequestMapping(value = "/listbyempid/{id}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable Integer id) {
			return empService.getEmployeeById(id);
	}

}
