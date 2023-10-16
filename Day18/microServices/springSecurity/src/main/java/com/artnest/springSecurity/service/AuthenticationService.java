package com.artnest.springSecurity.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.artnest.springSecurity.config.JwtService;
import com.artnest.springSecurity.dto.request.AuthenticationRequest;
import com.artnest.springSecurity.dto.request.RegisterRequest;
import com.artnest.springSecurity.dto.response.AuthenticationResponse;
import com.artnest.springSecurity.model.User;
import com.artnest.springSecurity.model.enumerated.Role;
import com.artnest.springSecurity.repository.userRepository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
        .name(request.getName())
        .email(request.getEmail())
        .pwd(passwordEncoder.encode(request.getPwd()))
        .isEnable(true)
        .role(Role.ARTIST)
        .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
        .token(jwtToken)

        .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
            )
        );
        var user = repository.findByEmail(request.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        
        return AuthenticationResponse.builder().token(jwtToken).userId(user.getId()).userName(user.getName()).build();
    }
    
}
