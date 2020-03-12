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
@Table(name = "resource_Allocation")
public class ResourceAllocation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	Employee[] employee;

	@ManyToOne
	@JoinColumn(name = "pro_id", nullable = false)
	private Project project;

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Employee[] getEmployee() {
		return employee;
	}

	public void setEmployee(Employee[] employee) {
		this.employee = employee;
	}

	
	public ResourceAllocation() {

	}

	

}
