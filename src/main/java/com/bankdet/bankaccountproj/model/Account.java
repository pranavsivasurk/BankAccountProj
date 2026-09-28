package com.bankdet.bankaccountproj.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Account {

    private String accountName;
    private String accountNumber;
    private String accountType;
    private double balance;

    public Account(){
        accountName="NONAME";
        accountNumber="NOACCNUM";
        accountType="NOTYPE";
        balance=-1;
    }
    public Account(String AccountName, String AccountNumber, double balance) {
        this.accountName = AccountName;
        this.accountNumber=AccountNumber;
        this.balance=balance;
    }

    public void deposit(double amount){
        balance+=amount;
    }
    public void withdraw(double amount){
        if(amount<=balance){
            balance-=amount;
        }else{
            System.out.println("Withdraw amount exceeds balance");
        }

    }

    public void getDetails(){
        System.out.println("Amount Name: "+accountName);
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Balance: "+balance);
    }
}
