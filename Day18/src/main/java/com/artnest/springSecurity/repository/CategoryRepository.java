package com.artnest.springSecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artnest.springSecurity.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    Optional<Category> existsByName(String name);
    
}
