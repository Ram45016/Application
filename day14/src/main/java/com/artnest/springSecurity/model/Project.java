package com.artnest.springSecurity.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="_projects")
public class Project {
    @Id
    @GeneratedValue(strategy =GenerationType.UUID)
    private String projectId;
    private String projectName;
    private String description;
    private String projectType;
    private String privacy;
    private List<String> members;
    private List<String> goals;
}
