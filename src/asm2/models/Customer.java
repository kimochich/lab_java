package asm2.models;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Customer extends User {

    public Customer() {
        accounts = new ArrayList<>();
    }

    private final List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    public boolean isPremium() {
        for (Account acc : accounts) {
            if (acc.isPremium()) {
                return true;
            }
        }
        return false;
    }

    public void addAccounts(Account newAccount) {
        for (Account acc : accounts) {
            // kiểm tra nếu trùng account number thì return luôn
            if (newAccount.getAccountNumber().equals(acc.getAccountNumber())) {
                System.out.println("Tai khoan da ton tai");
                return;
            }
        }
        // nếu không trùng thì them newAccount vào list
        accounts.add(newAccount);
    }

    public double getBalance() {
        double total = 0;
        for (Account acc : accounts) {
            total += acc.getBalance();
        }
        return total;
    }

    public void displayInformation() {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        System.out.printf("%-20s|%20s | %10s | %20sđ\n", getCustomerId(), getName(), (isPremium() ? "Premium" : "Normal"), formatter.format(getBalance()));
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            System.out.printf("%-6s%-14s| %55sđ\n", (i + 1), acc.getAccountNumber(), formatter.format(acc.getBalance()));
        }
    }

    public void displayTransaction() {
        displayInformation();
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            acc.displayTransaction();
        }
    }
}
