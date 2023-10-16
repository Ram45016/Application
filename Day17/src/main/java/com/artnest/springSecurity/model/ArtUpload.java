package com.artnest.springSecurity.model;

import jakarta.persistence.Entity;
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
@Entity
public class ArtUpload {
    @Id
    @GeneratedValue(strategy =GenerationType.UUID)
    private String artId;
    private String name;
    private String type;
    private String fileBytes;
}
