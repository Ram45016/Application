package com.artnest.springSecurity.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArtRequestDto {
    private String name;
    private String type;
    private String fileBytes;
}
