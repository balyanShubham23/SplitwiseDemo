package com.example.splitwisedemo.Repositories;

import com.example.splitwisedemo.Models.Expense;
import com.example.splitwisedemo.Models.ExpenseOwingUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseOwningUserRepository extends JpaRepository<ExpenseOwingUser, Long> {

    List<ExpenseOwingUser> findAllByExpense(Expense expense);
}
