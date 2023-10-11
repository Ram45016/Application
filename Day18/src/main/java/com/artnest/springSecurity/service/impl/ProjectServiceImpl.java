package com.artnest.springSecurity.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.artnest.springSecurity.dto.request.ProjectRequestDto;
import com.artnest.springSecurity.dto.response.ProjectResponeDto;
import com.artnest.springSecurity.model.Project;
import com.artnest.springSecurity.repository.CategoryRepository;
import com.artnest.springSecurity.repository.ProjectRepository;
import com.artnest.springSecurity.service.ProjectService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public boolean saveProject(ProjectRequestDto projectRequest) {

        Optional<Project> isProjectOptional = projectRepository.findByProjectName(projectRequest.getTitle());
        if (!isProjectOptional.isPresent()) {
            var project = Project.builder()
                    .projectName(projectRequest.getTitle())
                    .description(projectRequest.getDescription())
                    .privacy(projectRequest.getPrivacy())
                    .members(projectRequest.getMembers())
                    .goals(projectRequest.getGoals())
                    .category(categoryRepository.findById(Long.parseLong(projectRequest.getType())).orElseThrow())
                    .projectType(categoryRepository.findById(Long.parseLong(projectRequest.getType())).orElseThrow().getName())
                    .build();
            projectRepository.save(project);
            return true;
        } else {
            return false; // Project with the same name already exists
        }
    }

    @Override
    public List<ProjectResponeDto> getAllProjects() {
        List<Project> projectList = projectRepository.findAll();
        List<ProjectResponeDto> projectResponseList = new ArrayList<>();

        for (Project project : projectList) {
            ProjectResponeDto projectResponse = new ProjectResponeDto();
            projectResponse.setProjectId(project.getProjectId());
            projectResponse.setTitle(project.getProjectName());
            projectResponse.setDescription(project.getDescription());
            projectResponse.setPrivacy(project.getPrivacy());
            projectResponse.setType(project.getProjectType());
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
            project.setProjectName(projectRequest.getTitle());
            project.setDescription(projectRequest.getDescription());
            project.setProjectType(projectRequest.getType());
            project.setPrivacy(projectRequest.getPrivacy());
            project.setMembers(projectRequest.getMembers());
            project.setGoals(projectRequest.getGoals());
            projectRepository.save(project);
            return true;
        } else {
            return false; // Project not found
        }
    }

    @Override
    public boolean deleteProject(String projectId) {
        Optional<Project> optionalProject = projectRepository.findById(projectId);
        if (optionalProject.isPresent()) {
            projectRepository.deleteById(projectId);
            return true;
        } else {
            return false; // Project not found
        }
    }
    @Override
    public boolean deleteAllProject() {
        projectRepository.deleteAll(); // This will delete all projects in the repository
        return true; // You can return true to indicate that the operation was successful
    }
    
    
}
