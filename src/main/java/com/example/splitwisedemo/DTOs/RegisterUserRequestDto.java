package com.example.splitwisedemo.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequestDto {
    private String Name;
    private String PhoneNo;
    private String Password;
}
