package asm2.models;

import asm3.models.Transaction;
import asm3.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private double balance;

    private final List<Transaction> transactions = new ArrayList<>();

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(String accountNumber, double amount, String time, boolean status) {
        Transaction transaction = new Transaction();
        transaction.setAccountNumber(accountNumber);
        transaction.setAmount(amount);
        transaction.setTime(time);
        transaction.setStatus(status);
        transactions.add(transaction);
    }

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

    public void displayTransaction() {
        for (Transaction tran : transactions) {
            System.out.printf("%10s | %10s | %10s |  %10s\n", tran.getAccountNumber(), Utils.formatBalance(tran.getAmount()), tran.getTime(), tran.isStatus() ? "Thanh cong" : "That bai");
        }
    }
}
