package com.example.todoapp.service.serviceimpl;

import com.example.todoapp.dto.UserLoginDto;
import com.example.todoapp.dto.UserResponseDto;
import com.example.todoapp.dto.UserSignUpDto;
import com.example.todoapp.entity.User;
import com.example.todoapp.exception.ResourceNotFoundException;
import com.example.todoapp.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserServiceImpl userService;
    private String email;


    @Test
    void userSignUp() throws ResourceNotFoundException {
        var userSignUpDto = new UserSignUpDto();
        userSignUpDto.setFirstname("tom");
        userSignUpDto.setSurname("Lu");
        userSignUpDto.setPassword("111");
        userSignUpDto.setEmail("ooo@gmail.com");
        email = userSignUpDto.getEmail();

        User userSignUp = userService.userSignUp(userSignUpDto);
        assertEquals(userSignUpDto.getFirstname(), userSignUp.getFirstname());
    }

    @AfterEach
    public void tearDown(){
        userRepository.deleteByEmail(email);
    }





    @Test
    void shouldLoginInUserWithCorrectDetails() {
        var userLoginDto = new UserLoginDto();
        userLoginDto.setEmail("cj@gmail.com");
        userLoginDto.setPassword("9090");

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setEmail("cj@gmail.com");

        UserResponseDto user = userService.userLogin(userLoginDto, userResponseDto);
        assertEquals(user, userResponseDto);
    }
}
