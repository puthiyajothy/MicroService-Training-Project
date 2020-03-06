package com.java.employee.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
@Entity
@Table(name = "designation")
public class Designation implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer desi_id;
	private String designationname;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "designation", fetch = FetchType.EAGER)
	private List<Employee> employees;

	

	public Integer getDesi_id() {
		return desi_id;
	}
	public void setDesi_id(Integer desi_id) {
		this.desi_id = desi_id;
	}
	public String getDesignationname() {
		return designationname;
	}
	public void setDesignationname(String designationname) {
		this.designationname = designationname;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	
	

}
