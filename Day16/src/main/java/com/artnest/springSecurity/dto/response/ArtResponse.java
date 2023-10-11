package com.artnest.springSecurity.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArtResponse {
    private String artId;
    private String title;
    private String fileLocation;
    
}
