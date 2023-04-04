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

    private boolean isPremium() {
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
        System.out.println(getCustomerId() + "     |     " + (isPremium() ? "Premium" : "Normal") + "   |     " + formatter.format(getBalance()) + "đ");
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            System.out.println((i + 1) + "     " + acc.getAccountNumber() + "     |                   " + formatter.format(acc.getBalance()) + "đ");
        }
    }
}
