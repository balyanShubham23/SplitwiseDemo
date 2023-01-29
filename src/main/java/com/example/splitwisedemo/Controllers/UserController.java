package com.example.splitwisedemo.Controllers;

import com.example.splitwisedemo.DTOs.RegisterUserRequestDto;
import com.example.splitwisedemo.DTOs.RegisterUserResponseDto;
import com.example.splitwisedemo.Models.User;
import com.example.splitwisedemo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    public RegisterUserResponseDto RegisterUser(RegisterUserRequestDto registerUserRequestDto)
    {
        User user = userService.RegisterUser(registerUserRequestDto.getName(),registerUserRequestDto.getPhoneNo(),
                registerUserRequestDto.getPassword());
        RegisterUserResponseDto registerUserResponseDto = new RegisterUserResponseDto();
        registerUserResponseDto.setUser(user);
        return registerUserResponseDto;
    }
}
