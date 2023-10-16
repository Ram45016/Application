package com.artnest.springSecurity.repository;


import com.artnest.springSecurity.model.ArtUpload;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtRepository extends JpaRepository<ArtUpload, Long> {

    Optional<ArtUpload> existsByName(String name);
}
