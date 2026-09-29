package com.bankdet.bankaccountproj.controller;

import com.bankdet.bankaccountproj.model.Account;

import com.bankdet.bankaccountproj.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class BankController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/AddAccount")
    public ResponseEntity<Account> addNewAccount(@RequestBody Account account){
        return new ResponseEntity<Account>(accountService.addNewAccount(account), HttpStatus.CREATED);
    }

    @PostMapping("/updateAccountByNum")
    public ResponseEntity<Account> updateAccountByNum(@RequestBody Account account){
        return new ResponseEntity<Account>(accountService.updateAccount(account),HttpStatus.OK);
    }
    @PostMapping("/deleteAccount")
    public ResponseEntity<Account> deleteAccount(@RequestParam String accountNum){
        return new ResponseEntity<Account>(accountService.deleteAccount(accountNum),HttpStatus.OK);
    }
    @GetMapping("/GetAccounts")
    public List<Account> getAccounts(){
        return accountService.getAllAccounts();
    }

    @GetMapping("/GetAccountByNum")
    public ResponseEntity<Account> getAccountByAccNum(@RequestParam String accountNum){
        return new ResponseEntity<Account>(accountService.getAccountByNum(accountNum),HttpStatus.FOUND);
    }

}
