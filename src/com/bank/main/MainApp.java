package com.bank.main;

import com.bank.service.BankService;
import com.bank.gui.LoginFrame;

public class MainApp {
    public static void main(String[] args) {
        BankService bankService = new BankService();

        new LoginFrame(bankService);
    }
}