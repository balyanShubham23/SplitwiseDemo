package com.example.splitwisedemo.Repositories;

import com.example.splitwisedemo.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User save(User user);

    User findUserById(long Id);

    User findUserByUserNameAndPhoneNo(String userName, String phoneNo);
}
