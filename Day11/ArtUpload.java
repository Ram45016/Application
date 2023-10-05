package com.artnest.springSecurity.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArtUpload {
    @Id
    @GeneratedValue(strategy =GenerationType.UUID)
    private String artId;
    private String title;
    private String fileLocation;
}
