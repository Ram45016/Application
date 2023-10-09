package com.artnest.springSecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artnest.springSecurity.model.Project;

public interface ProjectRepository extends JpaRepository<Project,String>{

    Optional<Project> existsByProjectName(String projectName);
    
}
