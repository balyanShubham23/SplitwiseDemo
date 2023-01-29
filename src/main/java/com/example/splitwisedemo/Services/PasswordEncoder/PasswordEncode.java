package com.example.splitwisedemo.Services.PasswordEncoder;

public interface PasswordEncode {
    Boolean matches(String realPass, String HashedPass);

    String getEncodedPassword(String realPass);
}
