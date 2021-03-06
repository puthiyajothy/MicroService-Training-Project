package com.java.employee.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.java.employee.model.Employee;
import com.java.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	@Autowired
	RestTemplate restTemplate;

	@Bean
	@LoadBalanced
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

//	HttpHeaders httpHeaders = new HttpHeaders();
//	HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);

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
		Optional<Employee> optionalEmployee = empRepo.findById(id);
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
			boolean isExist = empRepo.findById(id) != null;
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

	@Override
	public List<Employee> listByEmployeebyid(Integer id) {
		Employee employee=new Employee();
		employee.setEmp_id(id);
        Example <Employee> example=Example.of(employee);
        List<Employee> employee1=empRepo.findAll(example);
        return employee1;

	}	

}
