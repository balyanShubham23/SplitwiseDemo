package com.example.splitwisedemo.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends BaseModel{
    private String userName;

    private String phoneNo;

    private String hashedPassword;

}
