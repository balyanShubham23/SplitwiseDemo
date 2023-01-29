package com.example.splitwisedemo.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Group extends BaseModel{
    private String name;

    //@ManyToMany
    private List<User> participants;

    //@ManyToMany
    private List<User> admins;

    private String description;

    //@ManyToOne
    private User createdBy;

    //@OneToMany
    private List<Expense> expenses;
}
