package com.example.splitwisedemo.Services;

import com.example.splitwisedemo.Models.User;
import com.example.splitwisedemo.Repositories.UserRepository;
import com.example.splitwisedemo.Services.PasswordEncoder.PasswordEncode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    private PasswordEncode passwordEncode;

    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public User RegisterUser(String UserName, String phoneNo, String Password)
    {
        User user = new User();
        user.setUserName(UserName);
        user.setPhoneNo(phoneNo);
        user.setHashedPassword(passwordEncode.getEncodedPassword(Password));

        return userRepository.save(user);
    }

    public User updateProfile(long UserId, String Password)
    {
        User user = userRepository.findUserById(UserId);
        user.setHashedPassword(Password);
        return userRepository.save(user);
    }

    private void Login(long UserID, String password)
    {
        User user = userRepository.findUserById(UserID);
        if(passwordEncode.matches(password,user.getHashedPassword()))
        {
            System.out.println("login success!!!");
        }
        else
        {
            System.out.println("login failed");
        }
    }
}
