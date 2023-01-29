package com.example.splitwisedemo.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Expense extends BaseModel{
    private Double amount;

    //@ManyToOne
    private User createdBy;

    private String description;

    //@ManyToOne
    private Currency baseCurrency;

    //@ManyToMany
    private List<User> participants;


}
