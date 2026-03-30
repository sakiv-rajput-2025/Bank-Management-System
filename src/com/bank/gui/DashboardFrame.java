package com.bank.gui;

import com.bank.model.User;
import com.bank.service.BankService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

public class DashboardFrame extends JFrame {

    private User user;
    private JLabel balanceLabel;
    private BankService bankService;

    public DashboardFrame(User user, BankService bankService) {
        this.user = user;
        this.bankService = bankService;

        setTitle("Dashboard");
        setSize(400, 300);
        setLayout(null);

        JLabel welcome = new JLabel("Welcome " + user.getUsername());
        welcome.setBounds(20, 20, 200, 25);
        add(welcome);

        balanceLabel = new JLabel("Balance: " + user.getAccount().getBalance());
        balanceLabel.setBounds(20, 60, 200, 25);
        add(balanceLabel);

        JButton depositBtn = new JButton("Deposit");
        depositBtn.setBounds(20, 100, 100, 30);
        add(depositBtn);

        JButton withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setBounds(140, 100, 100, 30);
        add(withdrawBtn);

        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setBounds(260, 100, 100, 30);
        add(logoutBtn);

        JButton historyBtn = new JButton("View History");
        historyBtn.setBounds(20, 150, 150, 30);
        add(historyBtn);

        historyBtn.addActionListener(e -> {
            try {
                BufferedReader reader = new BufferedReader(
                        new FileReader("data/" + user.getUsername() + "_transactions.txt"));

                String line;
                StringBuilder data = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    data.append(line).append("\n");
                }

                reader.close();

                JOptionPane.showMessageDialog(null, data.toString());

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No history found!");
            }
        });

        logoutBtn.addActionListener(e -> {
            new LoginFrame(bankService);
            dispose();
        });

        depositBtn.addActionListener(e -> {
            String amt = JOptionPane.showInputDialog("Enter amount:");

            try {
                double amount = Double.parseDouble(amt);

                if (amount <= 0 || amount > 10000) {
                    JOptionPane.showMessageDialog(null, "Amount must be between 1 and 10000!");
                    return;
                }

                user.getAccount().deposit(amount);
                bankService.getFileService().saveTransaction(user.getUsername(), "Deposit", amount);

                updateBalance();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid amount! Enter numbers only.");
            }
        });

        withdrawBtn.addActionListener(e -> {
            String amt = JOptionPane.showInputDialog("Enter amount:");

            try {
                double amount = Double.parseDouble(amt);

                if (amount <= 0 || amount > 10000) {
                    JOptionPane.showMessageDialog(null, "Amount must be between 1 and 10000!");
                    return;
                }

                user.getAccount().withdraw(amount);

                bankService.getFileService().saveTransaction(user.getUsername(), "Withdraw", amount);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid amount! Enter numbers only.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

            updateBalance();
        });

        setVisible(true);
    }

    private void updateBalance() {
        balanceLabel.setText("Balance: " + user.getAccount().getBalance());
    }
}