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
     * �Ա�
     */
    public void deposit(double amount) {
        this.balance += amount;
    }

    /**
     * ���(�ܾ� ���� ���ܸ� ����)
     * CheckingAccount ���� �ѵ����ܾ� �˻縦 �ϹǷ�,
     * �⺻ ������ �ܼ� �����ϰ� throws�� �����մϴ�.
     */
    public void withdraw(double amount) throws InsufficientBalanceException {
        this.balance -= amount;
    }

    @Override
    public String toString() {
        return String.format("���¹�ȣ: %s, ������: %s, �ܾ�: %.1f��",
                             accountNumber, ownerName, balance);
    }
}
