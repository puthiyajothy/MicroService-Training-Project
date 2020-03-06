package com.java.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.project.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
