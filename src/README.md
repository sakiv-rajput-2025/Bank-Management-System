# 🏦 Bank Management System (Java)

## 📌 Project Overview

The **Bank Management System** is a Java-based desktop application developed using **Java Swing GUI**. It allows users to perform basic banking operations such as registration, login, deposit, withdrawal, and viewing transaction history.

This project demonstrates important Java concepts like **OOP, File Handling, Multithreading, Collections, and GUI Programming**.

---

## 🚀 Features

* User Registration
* Secure Login System
* Deposit Money (Limit: ₹10,000 per transaction)
* Withdraw Money (Limit: ₹10,000 per transaction)
* Transaction History stored in file
* Logout Functionality
* Input Validation (no empty or invalid data)
* Case-insensitive usernames

---

## 🛠️ Technologies Used

* Java (Core Java)
* Java Swing (GUI)
* File Handling (BufferedReader, FileWriter)
* Multithreading (Thread class)
* Collections (HashMap)

---

## 📂 Project Structure

```
BankManagementSystem/
│
├── src/com/bank/
│   ├── main/
│   │   └── MainApp.java
│   ├── model/
│   │   ├── Account.java
│   │   ├── User.java
│   │   └── Transaction.java
│   ├── service/
│   │   ├── BankService.java
│   │   └── FileService.java
│   ├── threading/
│   │   └── TransactionThread.java
│   ├── exception/
│   │   └── InsufficientBalanceException.java
│   └── gui/
│       ├── LoginFrame.java
│       ├── RegisterFrame.java
│       └── DashboardFrame.java
│
├── data/
│   ├── accounts.txt
│   └── <username>_transactions.txt
│
└── README.md
```

---

## ▶️ How to Run

### 1. Compile the Project

```
javac com/bank/**/*.java
```

### 2. Run the Application

```
java com.bank.main.MainApp
```

---

## 📁 Data Storage

### 🔹 accounts.txt

Stores user details:

```
username,password,accountNo,balance
```

### 🔹 Transaction Files

Each user has a separate file:

```
username_transactions.txt
```

Stores:

```
type,amount,date
```

---

## 🧠 Concepts Used

* Object-Oriented Programming (OOP)
* Encapsulation
* Exception Handling
* Multithreading & Synchronization
* File Handling
* Java Swing GUI

---

## ⚠️ Validations Implemented

* Empty username/password not allowed
* Duplicate users prevented
* Case-insensitive usernames
* Only numeric values allowed for amount
* Transaction limit: ₹1 to ₹10,000

---

## 🔮 Future Enhancements

* Database integration (MySQL)
* Password encryption
* Improved UI using JavaFX
* Online banking features
* Admin panel

---

## 👨‍💻 Author

* Name: *Your Name*
* Course: *Your Course*
* College: *Your College Name*

---

## 📌 Note

This project is developed for academic purposes and demonstrates practical implementation of core Java concepts.

---
