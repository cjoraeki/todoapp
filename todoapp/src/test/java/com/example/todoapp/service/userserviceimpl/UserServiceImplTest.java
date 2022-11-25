package com.example.todoapp.service.userserviceimpl;

import com.example.todoapp.dto.UserLoginDto;
import com.example.todoapp.dto.UserSignUpDto;
import com.example.todoapp.entity.User;
import com.example.todoapp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class UserServiceImplTest {

    private UserRepository userRepository;

    private UserSignUpDto userSignUpDto;



    @Test
    void userSignUp() {
        UserSignUpDto userSignUpDto = new UserSignUpDto();
        userSignUpDto.setEmail("cj@gmail.com");
        String email = userSignUpDto.getEmail();

        assertEquals("cj@gmail.com", email);
    }

    @Test
    void shouldLoginInUserWithCorrectDetails() {
        UserServiceImpl userService = new UserServiceImpl(userRepository);
        User user = new User();
        user.setFirstname("Chijioke");

    }
}
