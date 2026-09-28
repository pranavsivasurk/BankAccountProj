package com.bankdet.bankaccountproj.service;

import com.bankdet.bankaccountproj.dao.AccountDAO;
import com.bankdet.bankaccountproj.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountDAO accountDAO;

    public List<Account> getAllAccounts(){
        return accountDAO.getAllAccounts();
    }

    public List<Account> getAccountByNum(String accountNum){
        return accountDAO.getAccountByNum(accountNum);
    }

    public int addNewAccount(Account account) {
        if(account.getAccountType()==null){
            account.setAccountType("No Type");
        }
        return accountDAO.addNewAccount(account);
    }
}
