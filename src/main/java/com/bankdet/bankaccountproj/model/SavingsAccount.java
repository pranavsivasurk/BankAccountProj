package com.bankdet.bankaccountproj.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SavingsAccount extends Account{

    private double interestRate;
    private int withdrawalLimit;
    private int withdrawalCount;


    public SavingsAccount(String AccountName, String AccountNumber, double balance, double interestRate, int withdrawalLimit, int withdrawalCount)
    {
        super(AccountName,AccountNumber,balance);
        this.interestRate=interestRate;
        this.withdrawalLimit=withdrawalLimit;
        this.withdrawalCount=withdrawalCount;

    }

    public void applyInterestRate(){
        double balance=super.getBalance();

        if(balance<=0){
            System.out.println("Cannot Apply Interest Rate, Balance  is Zero or Negative");
        }else if(interestRate<=0){
            System.out.println("Invalid Interest Rate");
        }else {
            balance*=interestRate;
            super.setBalance(balance);
        }
    }


    @Override
    public void deposit(double amount){
        if(amount<=0){
            System.out.println("Invalid Deposit Amount Deposit On Savings Account");
        }else{
            super.withdraw(amount);
        }
    }

    @Override
    public void withdraw(double amount){
        if(withdrawalCount+1>=withdrawalLimit){
            System.out.println("Withdrawal Limit Reached On Savings Account");
        }else if(amount<=0){
            System.out.println("Invalid Withdrawal Amount On Savings Account");
        }else{
            super.withdraw(amount);
        }
    }

}
