package com.bank.service;

import com.bank.model.User;
import com.bank.model.Account;

import java.io.*;
import java.util.HashMap;

public class FileService {

    private static final String FILE_NAME = "data/accounts.txt";

    // Save users to file
    public void saveUsers(HashMap<String, User> users) {
        try {
            File file = new File(FILE_NAME);

            // Create folder if not exists
            file.getParentFile().mkdirs();

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            for (User user : users.values()) {
                Account acc = user.getAccount();

                String data = user.getUsername() + "," +
                        user.getPassword() + "," +
                        acc.getAccountNumber() + "," +
                        acc.getBalance();

                writer.write(data);
                writer.newLine();
            }

            writer.close();

            System.out.println("Data saved to file!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveTransaction(String username, String type, double amount) {
        try {
            File file = new File("data/" + username + "_transactions.txt");
            file.getParentFile().mkdirs();

            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

            writer.write(type + "," + amount + "," + new java.util.Date());
            writer.newLine();

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load users from file
    public HashMap<String, User> loadUsers() {
        HashMap<String, User> users = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                String username = parts[0];
                String password = parts[1];
                int accNo = Integer.parseInt(parts[2]);
                double balance = Double.parseDouble(parts[3]);

                Account acc = new Account(accNo, username, balance);
                User user = new User(username, password, acc);

                users.put(username, user);
            }

            System.out.println("Data loaded from file!");

        } catch (IOException e) {
            System.out.println("No previous data found.");
        }

        return users;
    }
}