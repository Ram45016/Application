package com.artnest.springSecurity.service;

import java.util.List;

import com.artnest.springSecurity.dto.request.ProjectRequestDto;
import com.artnest.springSecurity.dto.response.ProjectResponeDto;

public interface ProjectService {

    boolean saveProject(ProjectRequestDto projectRequest);

    List<ProjectResponeDto> getAllProjects();

    boolean updateProject(String projectId, ProjectRequestDto projectRequest);

    boolean deleteProject(String projectId);

    boolean deleteAllProject();
    
}
