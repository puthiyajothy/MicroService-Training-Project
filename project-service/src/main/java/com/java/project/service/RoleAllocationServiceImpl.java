package com.java.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.project.model.RoleAllocation;
import com.java.project.repository.RoleAllocationRepository;

@Service
public class RoleAllocationServiceImpl implements RoleAllocationService {
	@Autowired
	RoleAllocationRepository roleRepo;
	

	@Override
	public RoleAllocation saverole(RoleAllocation roleAllocation) {
		// TODO Auto-generated method stub
		return roleRepo.save(roleAllocation);
	}

	@Override
	public List<RoleAllocation> listrole() {
		// TODO Auto-generated method stub
		return roleRepo.findAll();
	}

	@Override
	public RoleAllocation updateRoleAllocation(Integer role_id, RoleAllocation roleAllocation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleAllocation getByroleId(Integer role_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
