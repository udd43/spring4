package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;

import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class Bank {
    private List<Account> accounts = new ArrayList<>();
    private int nextAccountNumber = 1000;

    /**
     * ���� ���� ����
     */
    public String createSavingsAccount(String ownerName,
                                       double initialBalance,
                                       double interestRate) {
        String acctNo = "AC" + nextAccountNumber++;
        SavingsAccount sa = new SavingsAccount(acctNo, ownerName, initialBalance, interestRate);
        accounts.add(sa);
        System.out.printf(
            "Saving(����) ���°� �����Ǿ����ϴ�: ���¹�ȣ: %s, ������: %s, �ܾ�: %.1f��, ������: %.1f%%%n",
            acctNo, ownerName, initialBalance, interestRate);
        return acctNo;
    }

    /**
     * üŷ ���� ����
     */
    public String createCheckingAccount(String ownerName,
                                        double initialBalance,
                                        double withdrawalLimit) {
        String acctNo = "AC" + nextAccountNumber++;
        CheckingAccount ca = new CheckingAccount(acctNo, ownerName, initialBalance, withdrawalLimit);
        accounts.add(ca);
        System.out.printf(
            "üŷ ���°� �����Ǿ����ϴ�: ���¹�ȣ: %s, ������: %s, �ܾ�: %.1f��, ��� �ѵ�: %.1f��%n",
            acctNo, ownerName, initialBalance, withdrawalLimit);
        return acctNo;
    }

    /**
     * ���� ��ȸ
     */
    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        return accounts.stream()
            .filter(a -> a.getAccountNumber().equals(accountNumber))
            .findFirst()
            .orElseThrow(() ->
                new AccountNotFoundException(
                    String.format("���¹�ȣ %s�� �ش��ϴ� ���¸� ã�� �� �����ϴ�.", accountNumber))
            );
    }

    /**
     * �Ա�
     */
    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        Account acc = findAccount(accountNumber);
        acc.deposit(amount);
        System.out.printf("%.1f���� �ԱݵǾ����ϴ�. ���� �ܾ�: %.1f��%n",
                          amount, acc.getBalance());
    }

    /**
     * ���
     */
    public void withdraw(String accountNumber, double amount)
            throws AccountNotFoundException, InsufficientBalanceException, WithdrawalLimitExceededException {
        Account acc = findAccount(accountNumber);
        // CheckingAccount �� withdraw() �� �ѵ� �� �ܾ� �˻�
        if (acc instanceof CheckingAccount) {
            ((CheckingAccount) acc).withdraw(amount);
        } else {
            if (amount > acc.getBalance()) {
                throw new InsufficientBalanceException(
                    String.format("�ܾ��� �����մϴ�. ���� �ܾ�: %.1f��", acc.getBalance()));
            }
            acc.withdraw(amount);
        }
        System.out.printf("%.1f���� ��ݵǾ����ϴ�. ���� �ܾ�: %.1f��%n",
                          amount, acc.getBalance());
    }

    /**
     * �۱� (��� + �Ա�)
     */
    public void transfer(String fromAccount, String toAccount, double amount)
            throws AccountNotFoundException, InsufficientBalanceException, WithdrawalLimitExceededException {
        withdraw(fromAccount, amount);
        deposit(toAccount, amount);
        System.out.printf("%.1f���� %s���� %s�� �۱ݵǾ����ϴ�.%n",
                          amount, fromAccount, toAccount);
    }

    /**
     * ��� ���� ���
     */
    public void printAllAccounts() {
        System.out.println("=== ��� ���� ��� ===");
        accounts.forEach(a -> System.out.println(a));
        System.out.println("====================");
    }
}

