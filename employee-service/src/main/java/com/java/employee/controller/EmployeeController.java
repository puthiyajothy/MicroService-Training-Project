package com.java.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.java.employee.model.Employee;
import com.java.employee.repository.EmployeeRepository;
import com.java.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private EmployeeRepository empRepo;
	
	private static Logger logger = LogManager.getLogger(EmployeeController.class);

	@RequestMapping(value = "/saveemployee", method = RequestMethod.POST)
	public Employee saveemployee(@RequestBody Employee employee) {
		return empRepo.save(employee);
//		return empService.saveemployee(employee);
	}

	@RequestMapping(value = "/listemployee", method = RequestMethod.GET)
	public List<Employee> listemployees() {
		return empService.listemployees();
	}

	@RequestMapping(value = "/listbyempid/{id}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable Integer id) {
		return empService.getEmployeeById(id);
	}

	@RequestMapping(value="/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateemployee(@RequestBody Employee employee) {
		try {
			if (empService.updateemployee(employee) != null) {
				return new ResponseEntity<>("Successfully Updates", HttpStatus.OK);
			}
			return new ResponseEntity<>("Update Failed", HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("Employee Controller :-> Error" + ex.getMessage());
		}
		return null;
	}

	@RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE) // update Employee Using ID
	public ResponseEntity<String> deleteEmployeeByempId(@PathVariable("id") Integer id) {
		try {
			logger.info("Employee Controller :-> DeleteEmployeeById");
//			employeeDTOMapper.deleteByEmployeeId(empid.toUpperCase());
			empService.deleteEmployeeByempId(id);
			return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("Employee Controller :-> Error" + ex.getMessage());
		}
		return null;
	}
	
	@RequestMapping(value = "/employeebyid/{id}", method = RequestMethod.GET)
    public Employee[] getlistByEmpId(@PathVariable Integer id) {
        List<Employee> all = empService.listByEmployeebyid(id);
        return all.toArray(new Employee[all.size()]);
    }
}
