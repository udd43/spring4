package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account {
    private double withdrawalLimit; // ��� �ѵ�

    public CheckingAccount(String accountNumber, String ownerName,
                           double initialBalance, double withdrawalLimit) {
        super(accountNumber, ownerName, initialBalance);
        this.withdrawalLimit = withdrawalLimit;
    }

    public double getWithdrawalLimit() {
        return withdrawalLimit;
    }

    /**
     * ��� �ѵ� �� �ܾ��� �˻�
     */
    @Override
    public void withdraw(double amount)
            throws WithdrawalLimitExceededException, InsufficientBalanceException {
        if (amount > withdrawalLimit) {
            throw new WithdrawalLimitExceededException(
                String.format("��� �ѵ��� �ʰ��߽��ϴ�. �ѵ�: %.1f��", withdrawalLimit));
        }
        if (amount > getBalance()) {
            throw new InsufficientBalanceException(
                String.format("�ܾ��� �����մϴ�. ���� �ܾ�: %.1f��", getBalance()));
        }
        super.withdraw(amount);
    }

    @Override
    public String toString() {
        return super.toString() +
               String.format(", ��� �ѵ�: %.1f��", withdrawalLimit);
    }
}
