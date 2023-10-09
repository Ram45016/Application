package com.artnest.springSecurity.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artnest.springSecurity.dto.request.ProjectRequestDto;
import com.artnest.springSecurity.dto.response.ProjectResponeDto;
import com.artnest.springSecurity.service.ProjectService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;
    @PostMapping("/save")
	public ResponseEntity<String> saveProject(@RequestBody ProjectRequestDto projectRequest){
		boolean isDataSaved=projectService.saveProject(projectRequest); 
		return isDataSaved ? ResponseEntity.status(200).body("Project saved successfully"):
			ResponseEntity.status(403).body("Something went wrong");
	}

	@GetMapping("/all")
	public ResponseEntity<List<ProjectResponeDto>> getAllProjects() {
	 		List<ProjectResponeDto> projectList=projectService.getAllProjects();
		 	return projectList.size()>0? ResponseEntity.status(200).body(projectList):
		 		ResponseEntity.status(404).body(projectList);
	}

    @PutMapping("/update/{projectId}")
    public ResponseEntity<String> updateProject(@PathVariable String projectId, @RequestBody ProjectRequestDto projectRequest) {
        boolean isProjectUpdated = projectService.updateProject(projectId, projectRequest);
            return isProjectUpdated ? ResponseEntity.status(200).body("Project updated successfully") :
                ResponseEntity.status(404).body("Project not found with ID: " + projectId);
    }

    @DeleteMapping("/delete/{projectId}")
    public ResponseEntity<String> deleteProject(@PathVariable String projectId) {
        
        boolean isProjectDeleted = projectService.deleteProject(projectId);
            return isProjectDeleted ? ResponseEntity.status(200).body("Project deleted successfully") :
                ResponseEntity.status(404).body("Project not found with ID: " + projectId);
    }
    
}
