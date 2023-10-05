package com.artnest.springSecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artnest.springSecurity.model.ArtUpload;

public interface ArtRepository extends JpaRepository<ArtUpload,String>{

    Optional<ArtUpload> existsByTitle(String title);
    
}
