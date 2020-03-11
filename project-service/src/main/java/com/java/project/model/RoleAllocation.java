package com.java.project.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="role_Allocation")
public class RoleAllocation implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String role_id;
	
	@ManyToOne
	@JoinColumn(name = "sub_id", nullable = false)
	private SubModule subModule;

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public SubModule getSubModule() {
		return subModule;
	}

	public void setSubModule(SubModule subModule) {
		this.subModule = subModule;
	}

	
}
