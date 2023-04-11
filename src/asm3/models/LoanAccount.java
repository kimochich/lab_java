package asm3.models;

import asm2.models.Account;
import asm3.utils.Utils;
import jdk.jshell.execution.Util;

public class LoanAccount extends Account implements ReportService, Withdraw {

    private final float LOAN_ACCOUNT_WITHDRAW_FEE = 0.05f;
    private final float LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE = 0.01f;
    private final int LOAN_ACCOUNT_MAX_BALANCE = 100000000;

    @Override
    public void log(double amount) {
        System.out.println(Utils.getDivider());
        System.out.printf("%30s%n", "BIEN LAI GIAO DICH LOAN");
        System.out.printf("NGAY G/D: %28s%n", Utils.getDateTime());
        System.out.printf("ATM ID: %30s%n", "DIGITAL-BANK-ATM 2023");
        System.out.printf("SO TK: %32s%n", getAccountNumber());
        System.out.printf("SO TIEN: %30s%n", Utils.formatBalance(amount));
        System.out.printf("SO DU: %32s%n", Utils.formatBalance(getBalance() - amount - (amount * getTransactionFee())));
        System.out.printf("PHI + VAT: %27s%n", Utils.formatBalance(getTransactionFee() * amount));
        System.out.println(Utils.getDivider());
    }

    @Override
    public boolean withdraw(double amount) {
        addTransaction(getAccountNumber(), amount, Utils.getDateTime(), isAccepted(amount));
        if (isAccepted(amount)) {
            log(amount);
            setBalance(getBalance() - amount - (amount * getTransactionFee()));
            return true;
        } else {
            System.out.println("Giao dich that bai");
            return false;
        }
    }

    @Override
    public boolean isAccepted(double amount) {
        if ((getBalance() - (amount * getTransactionFee())) < 50000) {
            return false;
        }
        return !(amount > LOAN_ACCOUNT_MAX_BALANCE);
    }


    public float getTransactionFee() {
        if (isPremium()) {
            return LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE;
        } else {
            return LOAN_ACCOUNT_WITHDRAW_FEE;
        }
    }
}
