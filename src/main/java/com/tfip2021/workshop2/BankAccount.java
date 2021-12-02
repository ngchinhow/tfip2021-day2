// Module 1 Day 2 Workshop

package com.tfip2021.workshop2;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BankAccount {
    private int accountNumberMin = 10000000;
    private int accountNumberMax = 100000000;
    private DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
    private String accountHolderName;
    private String accountNumber = String.valueOf(
        ThreadLocalRandom.current().nextInt(
            accountNumberMin, accountNumberMax
        )
    );
    private float accountBalance;
    private ArrayList<String> transactions = new ArrayList<String>();
    private boolean closed = false;
    private String accountCreateDate = LocalDateTime.now().format(dtf);
    private String accountCloseDate;

    // constructors
    public BankAccount() { }
    public BankAccount(String name) {
        accountHolderName = name;
        accountBalance = 0;
    }
    public BankAccount(String name, float balance) {
        accountHolderName = name;
        accountBalance = balance;
    }

    // getters
    public String getAccountHolderName() { return this.accountHolderName; }
    public String getAccountNumber() { return this.accountNumber; }
    public float getAccountBalance() { return this.accountBalance; }
    public ArrayList<String> getTransactions() { return this.transactions; }
    public boolean isClosed() { return this.closed; }
    public String getAccountCreateDate() { return this.accountCreateDate; }
    public String getAccountCloseDate() { return this.accountCloseDate; }

    // setters
    protected void setAccountHolderName(String name) { this.accountHolderName = name; }
    protected void setAccountBalance(float balance) { this.accountBalance = balance; }
    protected void setTransactions(ArrayList<String> trans) { this.transactions = trans; }
    public void setIsClosed(boolean close) { this.closed = close; }
    public void setAccountCloseDate(String closeDate) { this.accountCloseDate = closeDate; }
    
    // methods
    public void deposit(float amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException(
                "Amount to deposit cannot be negative"
            );
        }
        else if (this.closed) {
            throw new IllegalArgumentException(
                "Amount cannot be deposited to closed Account"
            );
        }
        this.accountBalance += amount;
        this.transactions.add("deposit $" + amount + " at <" +
        LocalDateTime.now().format(this.dtf) + ">");
    }
    public void withdraw(float amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(
                "Amount to withdraw cannot be negative"
            );
        }
        else if (amount > this.getAccountBalance()) {
            throw new IllegalArgumentException(
                "Amount to withdraw is greater than Account balance"
            );
        }
        else if (this.closed) {
            throw new IllegalArgumentException(
                "Amount cannot be withdrawn from closed Account"
            );
        }
        this.accountBalance -= amount;
        this.transactions.add("withdraw $" + amount + " at <" +
        LocalDateTime.now().format(this.dtf) + ">");
    }
    public void closeAccount() {
        this.setIsClosed(true);
        this.setAccountCloseDate(LocalDateTime.now().format(this.dtf));
    }
}