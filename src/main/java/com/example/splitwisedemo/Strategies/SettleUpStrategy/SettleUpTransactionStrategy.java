package com.example.splitwisedemo.Strategies.SettleUpStrategy;

import com.example.splitwisedemo.Models.ExpenseOwingUser;
import com.example.splitwisedemo.Models.ExpensePayingUser;

import java.util.List;

public interface SettleUpTransactionStrategy {
    List<Transactions> getTransactions(List<ExpensePayingUser> expensePayingUsers,
                                       List<ExpenseOwingUser> expenseOwingUsers);
}
