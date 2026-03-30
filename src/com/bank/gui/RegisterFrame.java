package com.bank.gui;

import com.bank.service.BankService;

import javax.swing.*;

public class RegisterFrame extends JFrame {

    public RegisterFrame(BankService bankService) {

        setTitle("Register");
        setSize(300, 250);
        setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(20, 30, 80, 25);
        add(userLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(100, 30, 150, 25);
        add(usernameField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(20, 70, 80, 25);
        add(passLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(100, 70, 150, 25);
        add(passwordField);

        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(100, 120, 100, 30);
        add(registerBtn);

        registerBtn.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            // ❌ Check empty fields
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Username and Password cannot be empty!");
                return;
            }

            // ❌ Check minimum length (optional but good)
            if (password.length() < 3) {
                JOptionPane.showMessageDialog(null, "Password must be at least 3 characters!");
                return;
            }

            // ❌ Check if user already exists
            if (bankService.userExists(username)) {
                JOptionPane.showMessageDialog(null, "User already exists!");
                return;
            }

            // ✅ Register user
            bankService.register(username, password);

            JOptionPane.showMessageDialog(null, "Registered Successfully!");
            new LoginFrame(bankService);
            dispose();
        });

        setVisible(true);
    }
}