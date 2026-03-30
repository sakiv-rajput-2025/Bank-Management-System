package com.bank.model;

import com.bank.exception.InsufficientBalanceException;

public class Account {
    private int accountNumber;
    private String name;
    private double balance;

    // Constructor
    public Account(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    // Deposit method
    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    // Withdraw method (with exception)
    public synchronized void withdraw(double amount) throws InsufficientBalanceException {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            throw new InsufficientBalanceException("Not enough balance!");
        }
    }

    // Getters
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    // Setter (optional)
    public void setBalance(double balance) {
        this.balance = balance;
    }
}