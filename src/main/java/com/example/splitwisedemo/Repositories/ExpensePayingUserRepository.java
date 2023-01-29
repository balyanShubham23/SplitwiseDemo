package com.example.splitwisedemo.Repositories;

import com.example.splitwisedemo.Models.Expense;
import com.example.splitwisedemo.Models.ExpensePayingUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpensePayingUserRepository extends JpaRepository<ExpensePayingUser, Long> {

    List<ExpensePayingUser> findAllByExpense(Expense expense);
}

