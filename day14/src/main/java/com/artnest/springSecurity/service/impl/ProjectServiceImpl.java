package com.artnest.springSecurity.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.artnest.springSecurity.dto.request.ProjectRequestDto;
import com.artnest.springSecurity.dto.response.ProjectResponeDto;
import com.artnest.springSecurity.model.Project;
import com.artnest.springSecurity.repository.ProjectRepository;
import com.artnest.springSecurity.service.ProjectService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public boolean saveProject(ProjectRequestDto projectRequest) {
        Optional<Project> isProjectOptional=projectRepository.existsByProjectName(projectRequest.getProjectName());
        //projectRepository.existsByProjectName(projectRequest.getProjectName());
		if(isProjectOptional.isPresent()){
			var project=Project.builder()
					.projectName(projectRequest.getProjectName())
					.description(projectRequest.getDescription())
					.projectType(projectRequest.getProjectType())
                    .privacy(projectRequest.getPrivacy())
                    .members(projectRequest.getMembers())
                    .goals(projectRequest.getGoals())
					.build();
			projectRepository.save(project);
			return true;
		}
		else{
			return false;
		}
    }

    @Override
    public List<ProjectResponeDto> getAllProjects() {
        List<Project> projectList = projectRepository.findAll();
		List<ProjectResponeDto> projectResponseList = new ArrayList<>();
	
		for (Project project : projectList) {
			ProjectResponeDto projectResponse = new ProjectResponeDto(); 
			projectResponse.setProjectId(project.getProjectId());
			projectResponse.setProjectName(project.getProjectName());
			projectResponse.setDescription(project.getDescription());
			projectResponse.setPrivacy(project.getPrivacy());
			projectResponse.setProjectType(project.getProjectType());
			projectResponse.setMembers(project.getMembers());
			projectResponse.setGoals(project.getGoals());
	
			projectResponseList.add(projectResponse);
		}
	
		return projectResponseList;
    }

    @Override
    public boolean updateProject(String projectId, ProjectRequestDto projectRequest) {
        Optional<Project> optionalProject = projectRepository.findById(projectId);
        if (optionalProject.isPresent()) {
            Project project = optionalProject.get();
            project.setProjectName(projectRequest.getProjectName());
            project.setDescription(projectRequest.getDescription());
            project.setProjectType(projectRequest.getProjectType());
            project.setPrivacy(projectRequest.getPrivacy());
            project.setMembers(projectRequest.getMembers());
            project.setGoals(projectRequest.getGoals());
            projectRepository.save(project);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteProject(String projectId) {
        Optional<Project> optionalProject = projectRepository.findById(projectId);
        if (optionalProject.isPresent()) {
            projectRepository.deleteById(projectId);
            return true;
        } else {
            return false;
        }
    }

}
