package com.example.todoapp.dto;


import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class UserSignUpDto {

    @NotNull(message = "Firstname cannot be missing or empty")
    @Size(min = 2, message = "Firstname cannot be less than 2 characters")
    private String firstname;

    @NotNull(message = "Surname cannot be missing or empty")
    @Size(min = 2, message = "Surname must not be less than 2 characters")
    private String surname;

    @Email(message = "Email cannot be empty or email exists")
    @Column(unique=true)
    private String email;

    @NotNull(message = "Password is a required field")
    @Size(min = 4, max = 16, message = "Password must be greater than 3 characters and less than 16")
    private String password;
}
