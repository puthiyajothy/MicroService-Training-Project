package com.java.project.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.java.project.model.Employee;
import com.java.project.model.ResourceAllocation;
import com.java.project.repository.ResourceAllocationRepository;

import hystrixcommand.EmployeeCommand;

import java.util.Optional;

@Service
public class ResourceAllocationServiceImpl implements ResourceAllocationService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private ResourceAllocationRepository resourceRepo;
	
	
	@Autowired
	private static Logger logger = LogManager.getLogger(ResourceAllocationRepository.class);

	HttpHeaders httpHeaders = new HttpHeaders();
	HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);

	@Bean
	@LoadBalanced
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Override
	public ResourceAllocation saveresource(ResourceAllocation resourceAllocation) {
		return resourceRepo.save(resourceAllocation);
	}

	@Override
	public List<ResourceAllocation> gettAllResource() {
		return resourceRepo.findAll();
	}

	public Employee[] fetchAllocation(ResourceAllocation allocation) {
		EmployeeCommand empommand = new EmployeeCommand(allocation, httpHeaders, restTemplate);
		return empommand.execute();
	}

	@Override
	public ResourceAllocation getEmployee(Integer id) {
		Optional<ResourceAllocation> optionalallocation = resourceRepo.findById(id);
		if (optionalallocation.isPresent()) {
			ResourceAllocation allocation = optionalallocation.get();
//			ResponseEntity<Employee[]>responseEntity=restTemplate.exchange("http://EMPLOYEE/employeeservice/employeebyid/" +id, 
//					HttpMethod.GET,httpEntity,Employee[].class);
//			allocation.setEmployee(responseEntity.getBody());
//			return allocation;
//			allocation.setAllocation(fetchAllocation(allocation));
			allocation.setEmployee(fetchAllocation(allocation));
			return allocation;

		}
		return null;
	}

	@Override
	public ResourceAllocation findbyid(Integer id) {
		Optional<ResourceAllocation> optionalresource = resourceRepo.findById(id);
		if (optionalresource.isPresent()) {
			ResourceAllocation resource = optionalresource.get();
			return resource;
		} else
			return null;
	}

	@Override
	public List<ResourceAllocation> getresourceById() {
		return null;
	}

	@Override
	public void saveResourceTable(List<ResourceAllocation> allocation) {
		try {
			int size = allocation.size();
			int counter = 0;
			List<ResourceAllocation> temp = new ArrayList<>();

			for (ResourceAllocation emp : allocation) {
				logger.info("ResourceAllocationServiceImpl-->successfully Resource ---Get -- By --List");
				temp.add(emp);

				if ((counter + 1) % 500 == 0 || (counter + 1) == size) {
					logger.info("ResourceAllocationServiceImpl-->successfully Resource ---Get -- By --List Saved");
//					resourceAllocationRepository.saveAll(resourceAllocation);
					resourceRepo.saveAll(allocation);
					temp.clear();
				}
				counter++;
			}
		} catch (Exception ex) {
			logger.error("Resource Allocation Imp Error :-> " + ex.getMessage());
		}

	}

	@Override
	public ResourceAllocation deleteResourceById(Long resourceId) {
		// TODO Auto-generated method stub
		return null;
	}

}
