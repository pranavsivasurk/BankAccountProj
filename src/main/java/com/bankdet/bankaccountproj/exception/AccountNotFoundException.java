package com.bankdet.bankaccountproj.exception;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(String response){
        super(response);
    }
}
