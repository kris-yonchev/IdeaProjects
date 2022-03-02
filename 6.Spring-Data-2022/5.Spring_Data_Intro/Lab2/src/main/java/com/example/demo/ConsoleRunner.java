package com.example.demo;

import com.example.demo.models.Account;
import com.example.demo.models.User;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.AccountService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.HashSet;

@Component
@SpringBootApplication
public class ConsoleRunner implements CommandLineRunner {

    private final UserService userService;
    private final AccountService accountService;
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public ConsoleRunner(final UserService userService,
                         final AccountService accountService,
                         final UserRepository userRepository,
                         final AccountRepository accountRepository) {
        this.userService = userService;
        this.accountService = accountService;
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        User user = new User();
        user.setUserName("Pesho");
        user.setAge(23);
        user.setAccounts(new HashSet<>());

        Account account = new Account();
        account.setBalance(new BigDecimal("250000"));
        account.setUser(user);

        this.userService.registerUser(user);
        this.accountRepository.save(account);





        this.accountService.withdrawMoney(new BigDecimal("20000"), account.getId());
        this.accountService.transferMoney(new BigDecimal("30000"), account.getId());

    }
}
