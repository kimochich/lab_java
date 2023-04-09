package asm3.models;

public interface Withdraw {
    boolean withdraw(double amount);

    boolean isAccepted(double amount);
}
