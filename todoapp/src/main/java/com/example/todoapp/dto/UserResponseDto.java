package com.example.todoapp.dto;


import lombok.Data;

@Data
public class UserResponseDto {

    private Long user_id;
    private String firstname;
    private String surname;
    private String email;
}
