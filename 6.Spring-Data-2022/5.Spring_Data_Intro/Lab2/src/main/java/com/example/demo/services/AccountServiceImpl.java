package com.example.demo.services;

import com.example.demo.models.Account;
import com.example.demo.models.User;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;


    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal amount, Integer id) {

        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("account does not exist!"));

        if (account.getBalance().compareTo(amount) < 0) {
            throw new IllegalArgumentException("not enough money to withdraw!");
        }

        account.setBalance(account.getBalance().subtract(amount));
        this.accountRepository.save(account);

    }

    @Override
    public void transferMoney(BigDecimal amount, Integer id) {

        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("account does not exist!"));

        account.setBalance(account.getBalance().add(amount));
        this.accountRepository.save(account);

    }

}
