package com.example.splitwisedemo.DTOs;

import com.example.splitwisedemo.Strategies.SettleUpStrategy.Transactions;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpGroupResponseDto {
    List<Transactions> transactionsList;
}
