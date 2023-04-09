package asm3.models;

import asm2.models.Account;
import asm2.models.Customer;

import java.text.DecimalFormat;

public class DigitalCustomer extends Customer {
    public void withdraw(String accountNumber, double amount) {

    }

    @Override
    public void displayInformation() {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        System.out.printf("%-20s|%20s | %10s | %20sđ\n",getCustomerId(),getName(), (isPremium() ? "Premium" : "Normal"),formatter.format(getBalance()));
        for (int i = 0; i < getAccounts().size(); i++) {
            Account acc = getAccounts().get(i);
            System.out.printf("%-6s%-14s| %19s | %33sđ\n", (i + 1), acc.getAccountNumber(),(acc instanceof LoanAccount ? "LOAN" : "SAVINGS"), formatter.format(acc.getBalance()));
        }
    }

}
