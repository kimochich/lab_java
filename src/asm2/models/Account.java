package asm2.models;

public class Account {
    private String accountNumber;
    private double balance;

    public boolean isPremium() {
        return balance >= 10000000;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
