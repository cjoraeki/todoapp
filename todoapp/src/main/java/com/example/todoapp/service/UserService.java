package com.example.todoapp.service;

import com.example.todoapp.dto.UserLoginDto;
import com.example.todoapp.dto.UserResponseDto;
import com.example.todoapp.dto.UserSignUpDto;
import com.example.todoapp.entity.User;

public interface UserService {

    User userSignUp(UserSignUpDto userSignUpDto);

    UserResponseDto userLogin(UserLoginDto userLoginDto, UserResponseDto userResponseDto);

    void removeUserById(UserResponseDto userResponseDto);


}
