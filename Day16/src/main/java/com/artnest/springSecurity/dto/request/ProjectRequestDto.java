package com.artnest.springSecurity.dto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRequestDto {
    private String title;
    private String description;
    private String type;
    private String privacy;
    private List<String> members;
    private List<String> goals;
}
