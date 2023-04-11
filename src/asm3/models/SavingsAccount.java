package asm3.models;

import asm2.models.Account;
import asm3.utils.Utils;

public class SavingsAccount extends Account implements ReportService, Withdraw {

    private final int SAVINGS_ACCOUNT_MAX_WITHDRAW = 5000000;
    private final int SAVINGS_ACCOUNT_MIN_WITHDRAW = 50000;

    private final int SAVINGS_ACCOUNT_FEE = 0;

    @Override
    public void log(double amount) {
        System.out.println(Utils.getDivider());
        System.out.printf("%30s%n", "BIEN LAI GIAO DICH SAVINGS");
        System.out.printf("NGAY G/D: %28s%n", Utils.getDateTime());
        System.out.printf("ATM ID: %30s%n", "DIGITAL-BANK-ATM 2023");
        System.out.printf("SO TK: %32s%n", getAccountNumber());
        System.out.printf("SO TIEN: %30s%n", Utils.formatBalance(amount));
        System.out.printf("SO DU: %32s%n", Utils.formatBalance(getBalance() - amount - SAVINGS_ACCOUNT_FEE));
        System.out.printf("PHI + VAT: %27sđ%n", SAVINGS_ACCOUNT_FEE);
        System.out.println(Utils.getDivider());
    }

    @Override
    public boolean withdraw(double amount) {
        addTransaction(getAccountNumber(), amount, Utils.getDateTime(), isAccepted(amount));
        if (isAccepted(amount)) {
            log(amount);
            setBalance(getBalance() - amount - SAVINGS_ACCOUNT_FEE);
            return true;
        }
        System.out.println("Giao dich that bai");
        return false;
    }

    @Override
    public boolean isAccepted(double amount) {
        if (amount < SAVINGS_ACCOUNT_MIN_WITHDRAW) {
            return false;
        }
        if (!isPremium() && amount >= SAVINGS_ACCOUNT_MAX_WITHDRAW) {
            return false;
        }
        if ((getBalance() - amount) < SAVINGS_ACCOUNT_MIN_WITHDRAW) {
            return false;
        }
        return amount % 10000 == 0;
    }
}
