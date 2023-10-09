package com.artnest.springSecurity.userRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.artnest.springSecurity.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	Optional<User> existsByEmail(String email);

}
