package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account {
    private double withdrawalLimit; // 출금 한도

    public CheckingAccount(String accountNumber, String ownerName,
                           double initialBalance, double withdrawalLimit) {
        super(accountNumber, ownerName, initialBalance);
        this.withdrawalLimit = withdrawalLimit;
    }

    public double getWithdrawalLimit() {
        return withdrawalLimit;
    }

    /**
     * 출금 한도 및 잔액을 검사
     */
    @Override
    public void withdraw(double amount)
            throws WithdrawalLimitExceededException, InsufficientBalanceException {
        if (amount > withdrawalLimit) {
            throw new WithdrawalLimitExceededException(
                String.format("출금 한도를 초과했습니다. 한도: %.1f원", withdrawalLimit));
        }
        if (amount > getBalance()) {
            throw new InsufficientBalanceException(
                String.format("잔액이 부족합니다. 현재 잔액: %.1f원", getBalance()));
        }
        super.withdraw(amount);
    }

    @Override
    public String toString() {
        return super.toString() +
               String.format(", 출금 한도: %.1f원", withdrawalLimit);
    }
}
