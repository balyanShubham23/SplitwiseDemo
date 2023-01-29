package com.example.splitwisedemo.Strategies.SettleUpStrategy;

import com.example.splitwisedemo.Models.ExpenseOwingUser;
import com.example.splitwisedemo.Models.ExpensePayingUser;
import com.example.splitwisedemo.Models.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Qualifier("GreedySettleUpStrategy")
public class GreedySettleUpExpenseStrategy implements SettleUpTransactionStrategy{

    class Record
    {
        User user;

        Double pendingAmount;

        Record(User user, Double amount)
        {
            this.user = user;
            this.pendingAmount = amount;
        }
    }

    @Override
    public List<Transactions> getTransactions(List<ExpensePayingUser> expensePayingUsers,
                                              List<ExpenseOwingUser> expenseOwingUsers)
    {
        Map<User, Double> extraMoney = new HashMap<User, Double>();

        for(ExpensePayingUser expensePayingUser: expensePayingUsers)
        {
            if(!extraMoney.containsKey(expensePayingUser.getUser()))
            {
                extraMoney.put(expensePayingUser.getUser(), 0.0);
            }
            extraMoney.put(expensePayingUser.getUser(),
                    extraMoney.get(expensePayingUser.getUser()) + expensePayingUser.getAmount());
        }

        for(ExpenseOwingUser expenseowingUser: expenseOwingUsers)
        {
            if(!extraMoney.containsKey(expenseowingUser.getUser()))
            {
                extraMoney.put(expenseowingUser.getUser(), 0.0);
            }
            extraMoney.put(expenseowingUser.getUser(),
                    extraMoney.get(expenseowingUser.getUser()) - expenseowingUser.getAmount());
        }

        Queue<Record> positiveQueue = new ArrayDeque<>();
        Queue<Record> negativeQueue = new ArrayDeque<>();

        for(User user : extraMoney.keySet())
        {
            if(extraMoney.get(user) < 0)
            {
                negativeQueue.add(new Record(user, extraMoney.get(user)));
            }
            else if(extraMoney.get(user) > 0)
            {
                positiveQueue.add(new Record(user, extraMoney.get(user)));
            }
        }

        List<Transactions> transactions = new ArrayList<>();

        while(!positiveQueue.isEmpty() && !negativeQueue.isEmpty())
        {
            Record firstNegative = negativeQueue.remove();
            Record firstPositive = positiveQueue.remove();

            if(firstPositive.pendingAmount > Math.abs(firstNegative.pendingAmount))
            {
                transactions.add(new Transactions(firstNegative.user, firstPositive.user, Math.abs(firstNegative.pendingAmount)));
                positiveQueue.add(new Record(firstPositive.user, firstPositive.pendingAmount - Math.abs(firstNegative.pendingAmount)));
            }
            else
            {
                transactions.add(new Transactions(firstNegative.user, firstPositive.user, firstPositive.pendingAmount));
                negativeQueue.add(new Record(firstNegative.user, -firstPositive.pendingAmount + Math.abs(firstNegative.pendingAmount)));
            }
        }

        return transactions;
    }
}
