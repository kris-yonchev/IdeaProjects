package com.example.demo.services;

import com.example.demo.models.Account;

import java.math.BigDecimal;
import java.util.Optional;

public interface AccountService {

    void withdrawMoney(BigDecimal amount, Integer id);
    void transferMoney(BigDecimal amount, Integer id);
}
