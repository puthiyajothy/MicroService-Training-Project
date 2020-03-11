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
@Table(name="resource_Allocation")
public class ResourceAllocation implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer resourceId;
	private Integer emp_id;
	
	
	@ManyToOne
	@JoinColumn(name = "pro_id", nullable = false)
	private Project project;


	public Integer getResourceId() {
		return resourceId;
	}


	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}


	public Integer getEmp_id() {
		return emp_id;
	}


	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}


	public Project getProject() {
		return project;
	}


	public void setProject(Project project) {
		this.project = project;
	}

	
}
