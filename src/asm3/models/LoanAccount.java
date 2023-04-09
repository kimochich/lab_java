package asm3.models;

import asm2.models.Account;

public class LoanAccount extends Account implements ReportService, Withdraw {

    private final float LOAN_ACCOUNT_WITHDRAW_FEE = 0.05f;
    private final float LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE  = 0.01f;
    private final int LOAN_ACCOUNT_MAX_BALANCE = 100000000;

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
