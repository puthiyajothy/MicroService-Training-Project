package com.java.project.service;

import java.util.List;

import com.java.project.model.RoleAllocation;

public interface RoleAllocationService {

	public RoleAllocation saverole(RoleAllocation roleAllocation);

	public List<RoleAllocation> listrole();

	public RoleAllocation updateRoleAllocation(Integer role_id, RoleAllocation roleAllocation);

	public RoleAllocation getByroleId(Integer role_id);
}
