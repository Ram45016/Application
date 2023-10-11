package com.artnest.springSecurity.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectResponeDto {
    private String projectId;
    private String title;
    private String description;
    private String type;
    private String privacy;
    private List<String> members;
    private List<String> goals;
}
