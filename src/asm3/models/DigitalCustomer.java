package asm3.models;

import asm2.models.Account;
import asm2.models.Customer;
import asm3.utils.Utils;

public class DigitalCustomer extends Customer {

    public void withdraw(String accountNumber, double amount) {
        for (Account acc : getAccounts()) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                if (acc instanceof LoanAccount) {
                    ((LoanAccount) acc).withdraw(amount);
                } else if (acc instanceof SavingsAccount) {
                    ((SavingsAccount) acc).withdraw(amount);
                }
            }
        }
    }

    @Override
    public void displayInformation() {
        System.out.printf("%-20s|%20s | %10s | %20s\n", getCustomerId(), getName(), (isPremium() ? "Premium" : "Normal"), Utils.formatBalance(getBalance()));
        for (int i = 0; i < getAccounts().size(); i++) {
            Account acc = getAccounts().get(i);
            System.out.printf("%-6s%-14s| %19s | %33s\n", (i + 1), acc.getAccountNumber(), (acc instanceof LoanAccount ? "LOAN" : "SAVINGS"), Utils.formatBalance(acc.getBalance()));
        }
    }

}
