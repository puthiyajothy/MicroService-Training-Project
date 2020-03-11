package com.java.project.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "project")
public class Project implements Serializable {

	LocalDate todayDate = LocalDate.now();
	java.sql.Date currentDay = java.sql.Date.valueOf(todayDate);
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pro_id", unique = true)
	private Integer pro_id;
	@Pattern(regexp = "[a-z-A-Z]*", message = "Project Name can not contain invalid characters")
	private String name;
	@DateTimeFormat(iso = ISO.DATE)
	private Date startDate = currentDay;
	@DateTimeFormat(iso = ISO.DATE)
	private Date endDate = currentDay;
	private Long duration;
	@Pattern(regexp = "[a-z-A-Z]*", message = "Project Status can not contain invalid characters")
	private String status;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "Project", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Module> module;

	public Integer getPro_id() {
		return pro_id;
	}

	public void setPro_id(Integer pro_id) {
		this.pro_id = pro_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Module> getModule() {
		return module;
	}

	public void setModule(List<Module> module) {
		this.module = module;
	}

//	@OneToMany(mappedBy="project",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	private List<ResourceAllocation> resourceAllocation;

}
