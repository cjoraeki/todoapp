package com.example.todoapp.service.userserviceimpl;

import com.example.todoapp.dto.UserLoginDto;
import com.example.todoapp.dto.UserResponseDto;
import com.example.todoapp.dto.UserSignUpDto;
import com.example.todoapp.entity.User;
import com.example.todoapp.exception.ResourceNotFoundException;
import com.example.todoapp.repository.UserRepository;
import com.example.todoapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User userSignUp(UserSignUpDto userSignUpDto) {
        User user = new User();
        BeanUtils.copyProperties(userSignUpDto, user);
        return userRepository.save(user);
    }

    @Override
    public UserResponseDto userLogin(UserLoginDto userLoginDto, UserResponseDto userResponseDto) {
        User user = userRepository.findUserByEmail(userLoginDto.getEmail())
                .orElseThrow(()-> new ResourceNotFoundException("Email not found!", "Enter a valid email address"));

        if (user == null || !user.getPassword().equals(userLoginDto.getPassword())) {
            throw new ResourceNotFoundException("Invalid password", "Check the password and try again");
        }
        BeanUtils.copyProperties(user, userResponseDto);
        return userResponseDto;
    }

    @Override
    public void removeUserById(UserResponseDto userResponseDto){
        userRepository.deleteById(userResponseDto.getUser_id());
    }

}
