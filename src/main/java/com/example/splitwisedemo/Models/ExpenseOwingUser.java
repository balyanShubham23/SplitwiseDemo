package com.example.splitwisedemo.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpenseOwingUser extends BaseModel{

    private Expense expense;

    private User user;

    private Double amount;
}
