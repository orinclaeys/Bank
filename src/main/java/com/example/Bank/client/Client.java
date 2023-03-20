package com.example.Bank.client;

public class Client {

    private double balance;
    private String name;
    private int ID;
    private int accountNumber;

    public Client() {}

    public Client(double balance, String name, int ID, int accountNumber) {
        this.balance = balance;
        this.name = name;
        this.ID = ID;
        this.accountNumber = accountNumber;
    }

    //public Client(double balance, String name, int accountNumber) {
    //    this.balance = balance;
    //    this.name = name;
    //    this.accountNumber = accountNumber;
    //}

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "balance=" + balance +
                ", name='" + name + '\'' +
                ", ID=" + ID +
                ", accountNumber=" + accountNumber +
                '}';
    }

    public void deposit(Double amount){
        this.balance=this.balance+amount;
    }
    public void withdraw(Double amount){
        this.balance=this.balance-amount;
    }
}
