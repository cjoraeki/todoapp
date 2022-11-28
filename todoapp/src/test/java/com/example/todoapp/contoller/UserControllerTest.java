package com.example.todoapp.contoller;

import com.example.todoapp.dto.UserLoginDto;
import com.example.todoapp.dto.UserResponseDto;
import com.example.todoapp.dto.UserSignUpDto;
import com.example.todoapp.exception.ResourceNotFoundException;
import com.example.todoapp.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private UserService userService;


    @Test
    void userSignUpToApp() throws ResourceNotFoundException {
        try {
            UserSignUpDto userSignUpDto = new UserSignUpDto();
            userSignUpDto.setFirstname("Mark");
            userSignUpDto.setSurname("Cuban");
            userSignUpDto.setEmail("mc@yahoo.com");
            userSignUpDto.setPassword("0000");

            String requestBody = objectMapper.writeValueAsString(userSignUpDto);
            mockMvc.perform(post("/user/signup",201)
                    .contentType("application/json")
                    .content(requestBody))
                    .andExpect(status().isCreated());

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @After
    public void tearDown() {
    }


    @Test
    void userLoginUpOnToDoApp() {

        try {
            UserLoginDto userLoginDto = new UserLoginDto();
            userLoginDto.setEmail("0000");
            userLoginDto.setEmail("mc@yahoo.com");

            String responseBody = objectMapper.writeValueAsString(userLoginDto);
            mockMvc.perform(get("/user/login", 202)
                    .contentType("application/json")
                    .content(responseBody))
                    .andExpect(status().isAccepted());

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void deleteUser() {

        try {

            UserResponseDto userResponseDto = new UserResponseDto();
            userResponseDto.setUser_id(1L);
            userResponseDto.setEmail("0000");
            userResponseDto.setEmail("mc@yahoo.com");

            String body = objectMapper.writeValueAsString(userResponseDto);

            mockMvc.perform(delete("/user/delete", 200)
                    .contentType("/application/json")
                    .content(body));
//                    .andExpect(status().isOk());

        }catch (Exception exception){
            exception.printStackTrace();
        }

    }
}