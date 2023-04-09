package asm3.models;

import asm2.models.Account;

public class SavingsAccount extends Account implements ReportService, Withdraw {

    private final int SAVINGS_ACCOUNT_MAX_WITHDRAW = 5000000;

    @Override
    public void log(double amount) {

    }

    @Override
    public boolean withdraw(double amount) {
        return false;
    }

    @Override
    public boolean isAccepted(double amount) {
        return false;
    }
}
