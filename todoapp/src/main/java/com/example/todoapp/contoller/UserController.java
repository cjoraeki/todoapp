package com.example.todoapp.contoller;

import com.example.todoapp.dto.UserLoginDto;
import com.example.todoapp.dto.UserSignUpDto;
import com.example.todoapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> userSignUpToApp(@RequestBody UserSignUpDto userSignUpDto){
        userService.userSignUp(userSignUpDto);
        return new ResponseEntity<>("Sign up successful", HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity<String> userLoginUpOnToDoApp(@RequestBody UserLoginDto userLoginDto, UserSignUpDto userSignUpDto) {
        userService.userLogin(userLoginDto, userSignUpDto);
            return new ResponseEntity<>("Login successful", HttpStatus.ACCEPTED);
    }

}
