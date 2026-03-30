package com.bank.gui;

import com.bank.service.BankService;
import com.bank.model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private BankService bankService;

    public LoginFrame(BankService bankService) {
        this.bankService = bankService;

        setTitle("Bank Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(20, 30, 80, 25);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(100, 30, 150, 25);
        add(usernameField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(20, 70, 80, 25);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 70, 150, 25);
        add(passwordField);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(100, 110, 80, 25);
        add(loginBtn);

        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(190, 110, 100, 25);
        add(registerBtn);

        registerBtn.addActionListener(e -> {
            new RegisterFrame(bankService);
            dispose();
        });

        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                User user = bankService.login(username, password);

                if (user != null) {
                    JOptionPane.showMessageDialog(null, "Login Success!");

                    new DashboardFrame(user, bankService);
                    dispose();
                } else if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fields cannot be empty!");
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login!");
                }
            }
        });

        setVisible(true);
    }
}