package com.java.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.project.model.Developer;

public interface DeveloperRepository extends JpaRepository<Developer, Integer>{

}
