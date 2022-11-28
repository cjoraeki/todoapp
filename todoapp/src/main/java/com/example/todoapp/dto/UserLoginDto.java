package com.example.todoapp.dto;


import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserLoginDto {

    @Email(message = "Email is a required field")
    private String email;

    @NotNull(message = "Password is a required field")
    @Size(min = 8, max = 10, message = "Password must be equal to or greater than 8 characters and less than 10")
    private String password;
}
