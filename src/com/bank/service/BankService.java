package com.bank.service;

import com.bank.model.User;
import com.bank.model.Account;

import java.util.HashMap;

public class BankService {

    private HashMap<String, User> users = new HashMap<>();
    private FileService fileService = new FileService();

    // Register user
    public void register(String username, String password) {
        Account acc = new Account(users.size() + 1, username, 1000);
        User user = new User(username, password, acc);

        users.put(username, user);
        System.out.println("User registered successfully!");

        users.put(username, user);
        fileService.saveUsers(users);
    }

    // Login user
    public User login(String username, String password) {
        if (users.containsKey(username)) {
            User user = users.get(username);

            if (user.getPassword().equals(password)) {
                System.out.println("Login successful!");
                return user;
            } else {
                System.out.println("Wrong password!");
            }
        } else {
            System.out.println("User not found!");
        }
        return null;
    }

    public BankService() {
        users = fileService.loadUsers();
    }

    public FileService getFileService() {
        return fileService;
    }

    public boolean userExists(String username) {
        return users.containsKey(username);
    }

    public String loginStatus(String username, String password) {
        if (!users.containsKey(username)) {
            return "USER_NOT_FOUND";
        }

        User user = users.get(username);

        if (!user.getPassword().equals(password)) {
            return "WRONG_PASSWORD";
        }

        return "SUCCESS";
    }
}