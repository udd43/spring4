package mylab.bank.control;

import mylab.bank.entity.Bank;
import mylab.bank.entity.SavingsAccount;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // === ���� ���� ===
        String acc1 = bank.createSavingsAccount("ȫ�浿", 10000.0, 3.0);
        String acc2 = bank.createCheckingAccount("��ö��", 20000.0, 5000.0);
        String acc3 = bank.createSavingsAccount("�̿���", 30000.0, 2.0);
        System.out.println();

        // === ��� ���� ��� ===
        bank.printAllAccounts();
        System.out.println();

        // === �Ա�/��� �׽�Ʈ ===
        try {
            bank.deposit(acc1, 5000.0);
            bank.withdraw(acc1, 3000.0);
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
        System.out.println();

        // === ���� ���� �׽�Ʈ ===
        try {
            SavingsAccount sa = (SavingsAccount) bank.findAccount(acc1);
            double interest = sa.getBalance() * sa.getInterestRate() / 100.0;
            sa.deposit(interest);
            System.out.printf("%.1f���� �ԱݵǾ����ϴ�. ���� �ܾ�: %.1f��%n",
                              interest, sa.getBalance());
            sa.applyInterest();
        } catch (AccountNotFoundException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
        System.out.println();

        // === ���� ��ü �׽�Ʈ ===
        try {
            bank.transfer(acc2, acc3, 5000.0);
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
        System.out.println();

        // === ���� ���� ��� ===
        bank.printAllAccounts();
        System.out.println();

        // === ���� �߻� �׽�Ʈ ===
        try {
            bank.withdraw(acc2, 6000.0);
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
        try {
            bank.withdraw(acc2, 7000.0);
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
        try {
            bank.findAccount("AC9999");
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
    }
}
