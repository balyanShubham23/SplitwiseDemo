package com.example.splitwisedemo.Strategies.SettleUpStrategy;

import com.example.splitwisedemo.Models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transactions {
    private User From;

    private User To;

    private Double Amount;

    public Transactions(User from, User To, Double amount)
    {
        this.From = from;
        this.To = To;
        this.Amount = amount;
    }
}
