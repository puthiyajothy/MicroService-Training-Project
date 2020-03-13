package com.java.project.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
@Entity
@Table(name="submodule")
public class SubModule implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sub_id;
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "mod_id", nullable = false)
	private Module module;

	
	public Integer getSub_id() {
		return sub_id;
	}

	public void setSub_id(Integer sub_id) {
		this.sub_id = sub_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "subModule", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<RoleAllocation> roleAllocation;


	public List<RoleAllocation> getRoleAllocation() {
		return roleAllocation;
	}

	public void setRoleAllocation(List<RoleAllocation> roleAllocation) {
		this.roleAllocation = roleAllocation;
	}


}
