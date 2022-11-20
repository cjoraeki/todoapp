package com.example.todoapp.dto;


import lombok.Data;

@Data
public class UserSignUpDto {

    private String firstname;
    private String surname;
    private String email;
    private String password;
}
