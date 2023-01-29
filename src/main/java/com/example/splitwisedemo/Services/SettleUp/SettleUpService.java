package com.example.splitwisedemo.Services.SettleUp;

import com.example.splitwisedemo.Models.Expense;
import com.example.splitwisedemo.Models.ExpenseOwingUser;
import com.example.splitwisedemo.Models.ExpensePayingUser;
import com.example.splitwisedemo.Models.Group;
import com.example.splitwisedemo.Repositories.ExpenseOwningUserRepository;
import com.example.splitwisedemo.Repositories.ExpensePayingUserRepository;
import com.example.splitwisedemo.Repositories.GroupRepository;
import com.example.splitwisedemo.Strategies.SettleUpStrategy.SettleUpTransactionStrategy;
import com.example.splitwisedemo.Strategies.SettleUpStrategy.Transactions;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Service
public class SettleUpService {

    @Autowired
    @Qualifier("GreedySettleUpStrategy")
    private SettleUpTransactionStrategy settleUpTransactionStrategy;

    private GroupRepository groupRepository;
    private ExpensePayingUserRepository expensePayingUserRepository;
    private ExpenseOwningUserRepository expenseOwningUserRepository;

    @Autowired
    public void SettleUpService(SettleUpTransactionStrategy settleUpTransactionStrategy)
    {
        this.settleUpTransactionStrategy = settleUpTransactionStrategy;
    }

    public List<Transactions> settleUpGroup(Long groupId)
    {
        Optional<Group> groups = groupRepository.findById(groupId);

        if(!groups.isPresent())
        {
            System.out.println("group is not present.");
        }

        Group group = groups.get();

        List<ExpensePayingUser> expensePayingUsers = new ArrayList<>();
        List<ExpenseOwingUser> expenseOwingUsers = new ArrayList<>();

        for (Expense expense: group.getExpenses())
        {
            expensePayingUsers.addAll(expensePayingUserRepository.findAllByExpense(expense));
            expenseOwingUsers.addAll(expenseOwningUserRepository.findAllByExpense(expense));
        }

        return settleUpTransactionStrategy.getTransactions(expensePayingUsers, expenseOwingUsers);
    }
}
