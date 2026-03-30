package com.bank.threading;

import com.bank.model.Account;
import com.bank.exception.InsufficientBalanceException;

public class TransactionThread extends Thread {

    private Account account;
    private double amount;
    private String type; // deposit or withdraw

    public TransactionThread(Account account, double amount, String type) {
        this.account = account;
        this.amount = amount;
        this.type = type;
    }

    @Override
    public void run() {
        try {
            if (type.equalsIgnoreCase("deposit")) {
                account.deposit(amount);
            } else if (type.equalsIgnoreCase("withdraw")) {
                account.withdraw(amount);
            }
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}