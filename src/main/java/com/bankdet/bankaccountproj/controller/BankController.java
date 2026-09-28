package com.bankdet.bankaccountproj.controller;

import com.bankdet.bankaccountproj.model.Account;

import com.bankdet.bankaccountproj.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class BankController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/AddAccount")
    public int addNewAccount(@RequestBody Account account){
        return accountService.addNewAccount(account);
    }

    @GetMapping("/AccountExample")
    public Account getAccount(){

        return new Account("Siva","999999",1000);
    }

    @GetMapping("/GetAccounts")
    public List<Account> getAccounts(){

        return accountService.getAllAccounts();
    }

    @GetMapping("/GetAccountByNum")
    public List<Account> getAccountByACCNUM(@RequestParam String accountNum){

        return accountService.getAccountByNum(accountNum);
    }

}
