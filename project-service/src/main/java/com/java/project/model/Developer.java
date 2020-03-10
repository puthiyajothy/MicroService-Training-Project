package com.java.project.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name="developer")
public class Developer implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer dev_id;
	private String name;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy="developer",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Module> Module;

	public Integer getDev_id() {
		return dev_id;
	}

	public void setDev_id(Integer dev_id) {
		this.dev_id = dev_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Module> getModule() {
		return Module;
	}

	public void setModule(List<Module> module) {
		Module = module;
	}
	

	

}
