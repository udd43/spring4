package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

public abstract class Account {
    private String accountNumber;
    private String ownerName;
    protected double balance;

    public Account(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * 입금
     */
    public void deposit(double amount) {
        this.balance += amount;
    }

    /**
     * 출금(잔액 부족 예외만 선언)
     * CheckingAccount 에서 한도·잔액 검사를 하므로,
     * 기본 구현은 단순 차감하고 throws만 선언합니다.
     */
    public void withdraw(double amount) throws InsufficientBalanceException {
        this.balance -= amount;
    }

    @Override
    public String toString() {
        return String.format("계좌번호: %s, 소유자: %s, 잔액: %.1f원",
                             accountNumber, ownerName, balance);
    }
}
