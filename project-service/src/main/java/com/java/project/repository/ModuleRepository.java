package com.java.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.project.model.Module;

public interface ModuleRepository extends JpaRepository<Module, Integer>{

}
