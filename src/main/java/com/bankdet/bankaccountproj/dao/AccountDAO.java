package com.bankdet.bankaccountproj.dao;


import java.util.List;


import com.bankdet.bankaccountproj.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Account> getAllAccounts(){
        String sql="SELECT AccountName,AccountNumber,AccountBalance AS balance,AccountType FROM bankacc.AccountDetails";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Account.class));
    }

    public Account getAccountByNum(String accountNum){
        String sql="Select AccountName,AccountNumber,AccountBalance AS balance,AccountType From bankacc.AccountDetails WHERE AccountDetails.AccountNumber =?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class),accountNum);
    }

    public Account addNewAccount(Account account) {
        String sql="INSERT INTO bankacc.AccountDetails (AccountName, AccountNumber, AccountBalance,AccountType) VALUES (?, ?, ?,?) ";
        jdbcTemplate.update(sql,account.getAccountName(),account.getAccountNumber(),account.getBalance(),account.getAccountType());

        return account;
    }

    public Account updateAccount(Account account) {
        String sql="UPDATE bankacc.AccountDetails SET AccountName=?,AccountNumber=?,AccountBalance=?,AccountType=? WHERE AccountNumber=?";
        jdbcTemplate.update(sql,account.getAccountName(),account.getAccountNumber(),account.getBalance(),account.getAccountType(),account.getAccountNumber());
        return account;
    }

    public Account deleteAccount(String accountNum) {
        String sql="DELETE FROM bankacc.AccountDetails WHERE AccountNumber=?";
        Account resultAcc=getAccountByNum(accountNum);
        jdbcTemplate.update(sql,accountNum);

        return resultAcc;
    }
}
