package com.java.project.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="submodule")
public class SubModule implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String sub_id;
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "mod_id", nullable = false)
	private Module module;

	public String getSub_id() {
		return sub_id;
	}

	public void setSub_id(String sub_id) {
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


}
