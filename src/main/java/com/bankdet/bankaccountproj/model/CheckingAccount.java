package com.bankdet.bankaccountproj.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CheckingAccount extends Account{

    private String routingNum;
    private int transactionCount;
    private int transactionLimit;

    public CheckingAccount (String AccountName, String AccountNumber, double balance,String routingNum,int transactionCount,int transactionLimit){
        super(AccountName,AccountNumber,balance);
        this.routingNum=routingNum;
        this.transactionCount=transactionCount;
        this.transactionLimit=transactionLimit;
    }


    @Override
    public void deposit(double amount){

        if((transactionCount+1) >= transactionLimit){
            System.out.println("Transaction Limit Reached on Checking Account");
        }else if(amount<=0){
            System.out.println("Invalid Amount for Checking Deposit");
        }else{
            transactionCount++;
            super.deposit(amount);
            System.out.println("Deposit Completed Successfully");
        }
    }
    @Override
    public void withdraw(double amount){
        if((transactionCount+1) >= transactionLimit) {
            System.out.println("Transaction Limit Reached On Savings Account");
        }else if(amount<=0) {
            System.out.println("Invalid Amount for Checking Withdrawal");
        }else{
            transactionCount++;
            super.withdraw(amount);
            System.out.println("Withdrawal Completed Successfully");
        }
    }

    @Override
    public void getDetails(){
        super.getDetails();
        System.out.println("Checking Account Routing Number:"+routingNum);
        System.out.println("Checking Account Transaction Count:"+transactionCount);
        System.out.println("Checking Account Transaction Limit:"+transactionLimit);
    }

}
