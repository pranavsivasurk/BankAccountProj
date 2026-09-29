package com.bankdet.bankaccountproj.service;

import com.bankdet.bankaccountproj.dao.AccountDAO;
import com.bankdet.bankaccountproj.exception.AccountNotFoundException;
import com.bankdet.bankaccountproj.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountDAO accountDAO;

    public List<Account> getAllAccounts(){
        return accountDAO.getAllAccounts();
    }

    public Account getAccountByNum(String accountNum){
        Account resultAcc=accountDAO.getAccountByNum(accountNum);
        if(resultAcc==null){
            throw new AccountNotFoundException("Account Not Found");
        }
        return resultAcc;
    }

    public Account addNewAccount(Account account) {
        if(account.getAccountType()==null){
            account.setAccountType("No Type");
        }
        return accountDAO.addNewAccount(account);
    }

    public Account updateAccount(Account account) {
        Account resultAccount=accountDAO.updateAccount(account);
        if(resultAccount==null){
            throw new AccountNotFoundException("Account Not Found");
        }
        return resultAccount;
    }

    public Account deleteAccount(String accountNum) {
        Account resultAccount=accountDAO.deleteAccount(accountNum);
        if(resultAccount==null){
            throw new AccountNotFoundException("Account Not Found");
        }
        return resultAccount;
    }
}
