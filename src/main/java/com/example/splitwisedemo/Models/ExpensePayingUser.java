package com.example.splitwisedemo.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpensePayingUser extends BaseModel{

    //@ManyToOne
    private Expense expense;

    //@ManyToOne
    private User user;

    private Double amount;
}
