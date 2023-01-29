package com.example.splitwisedemo.Controllers;

import com.example.splitwisedemo.DTOs.SettleUpGroupRequestDto;
import com.example.splitwisedemo.DTOs.SettleUpGroupResponseDto;
import com.example.splitwisedemo.Services.SettleUp.SettleUpService;
import com.example.splitwisedemo.Strategies.SettleUpStrategy.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettleUpController {
    @Autowired
    private SettleUpService settleUpService;

    public SettleUpGroupResponseDto settleUpGroup(SettleUpGroupRequestDto settleUpGroupRequestDto)
    {
        List<Transactions> transactions = settleUpService.settleUpGroup(settleUpGroupRequestDto.getGroupId());
        SettleUpGroupResponseDto settleUpGroupResponseDto = new SettleUpGroupResponseDto();
        settleUpGroupResponseDto.setTransactionsList(transactions);
        return settleUpGroupResponseDto;
    }
}
