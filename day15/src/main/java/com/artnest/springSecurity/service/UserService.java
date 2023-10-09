package com.artnest.springSecurity.service;

import java.util.List;

import com.artnest.springSecurity.dto.request.UserRequestDto;
import com.artnest.springSecurity.dto.response.UserResponseDto;

public interface UserService {

	List<UserResponseDto> getAllUser();

	boolean saveUser(UserRequestDto userRequest);

}
