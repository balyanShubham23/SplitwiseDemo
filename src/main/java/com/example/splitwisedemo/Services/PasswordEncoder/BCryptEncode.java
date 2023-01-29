package com.example.splitwisedemo.Services.PasswordEncoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BCryptEncode implements PasswordEncode{
    private BCryptPasswordEncoder springBCryptEncoder = new BCryptPasswordEncoder();

    @Override
    public Boolean matches(String realPass, String HashedPass) {
        return springBCryptEncoder.matches(realPass, HashedPass);
    }

    @Override
    public String getEncodedPassword(String realPass) {
        return springBCryptEncoder.encode(realPass);
    }
}
