package com.artnest.springSecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artnest.springSecurity.model.User;


public interface UserRepositories extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
