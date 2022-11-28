package com.example.todoapp.contoller;

import com.example.todoapp.dto.UserLoginDto;
import com.example.todoapp.dto.UserResponseDto;
import com.example.todoapp.dto.UserSignUpDto;
import com.example.todoapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> userSignUpToApp(@Valid @RequestBody UserSignUpDto userSignUpDto) {
        userService.userSignUp(userSignUpDto);
        return new ResponseEntity<>("Sign up successful", HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity<String> userLoginUpOnToDoApp(@RequestBody UserLoginDto userLoginDto, UserResponseDto userResponseDto) {
        userService.userLogin(userLoginDto, userResponseDto);
        return new ResponseEntity<>("Login successful", HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestBody UserResponseDto userResponseDto) {
        userService.removeUserById(userResponseDto);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }
}
