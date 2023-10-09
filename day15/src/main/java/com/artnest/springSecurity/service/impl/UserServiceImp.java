package com.artnest.springSecurity.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.artnest.springSecurity.dto.request.UserRequestDto;
import com.artnest.springSecurity.dto.response.UserResponseDto;
import com.artnest.springSecurity.model.User;
import com.artnest.springSecurity.service.UserService;
import com.artnest.springSecurity.userRepository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImp implements UserService{
	private final UserRepository userRepository;

	

	@Override
	public boolean saveUser(UserRequestDto userRequest) {
		Optional<User> isUserOptional=userRepository.existsByEmail(userRequest.getEmail());
		if(isUserOptional.isPresent()){
			var user=User.builder()
					.name(userRequest.getUsername())
					.email(userRequest.getEmail().toLowerCase())
					.pwd(userRequest.getPassword())
					.build();
			userRepository.save(user);
			return true;
		}
		else{
			return false;
		}
	}
	@Override
	public List<UserResponseDto> getAllUser() {
		List<User> userList = userRepository.findAll();
		List<UserResponseDto> userResponseList = new ArrayList<>();
	
		for (User user : userList) {
			UserResponseDto userResponse = new UserResponseDto(); 
			userResponse.setId(user.getId());
			userResponse.setUsername(user.getUsername());
			userResponse.setEmail(user.getEmail());
			userResponse.setPassword(user.getPassword());
	
			userResponseList.add(userResponse);
		}
	
		return userResponseList;
	}
	
	
	
	
		
}
