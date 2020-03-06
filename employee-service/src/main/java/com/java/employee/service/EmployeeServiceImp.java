package com.java.employee.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.java.employee.model.Employee;
import com.java.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService{
	
	@Autowired
	private  EmployeeRepository empRepo;

	private static Logger logger = LogManager.getLogger(EmployeeRepository.class);

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

	@Override
	public Employee updateEmployee(Employee employee) {
		try {
			Integer id = employee.getId();
			boolean isExist = empRepo.findById(id)!=null;
			if (isExist) {
				return empRepo.save(employee);
			} else {
				logger.info("Employee Id is Not Found");
			}

		} catch (Exception ex) {
			logger.error("Employee Service Imp:--> Error" + ex.getMessage());
		}

		return null;
	}

	@Override
	public List<Employee> getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployeeByempId(Integer id) {
		try {
			logger.info("Delete Employee Details Methods");
			empRepo.deleteById(id);
		} catch (Exception ex) {
			logger.error("Employee Service Imp:--> Error" + ex.getMessage());
		}
	}

	@Override
	public List<Employee> getByDesignation(Integer designationid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	

}
