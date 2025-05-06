package mylab.bank.control;

import mylab.bank.entity.Bank;
import mylab.bank.entity.SavingsAccount;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // === 계좌 생성 ===
        String acc1 = bank.createSavingsAccount("홍길동", 10000.0, 3.0);
        String acc2 = bank.createCheckingAccount("김철수", 20000.0, 5000.0);
        String acc3 = bank.createSavingsAccount("이영희", 30000.0, 2.0);
        System.out.println();

        // === 모든 계좌 출력 ===
        bank.printAllAccounts();
        System.out.println();

        // === 입금/출금 테스트 ===
        try {
            bank.deposit(acc1, 5000.0);
            bank.withdraw(acc1, 3000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        System.out.println();

        // === 이자 적용 테스트 ===
        try {
            SavingsAccount sa = (SavingsAccount) bank.findAccount(acc1);
            double interest = sa.getBalance() * sa.getInterestRate() / 100.0;
            sa.deposit(interest);
            System.out.printf("%.1f원이 입금되었습니다. 현재 잔액: %.1f원%n",
                              interest, sa.getBalance());
            sa.applyInterest();
        } catch (AccountNotFoundException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        System.out.println();

        // === 계좌 이체 테스트 ===
        try {
            bank.transfer(acc2, acc3, 5000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        System.out.println();

        // === 최종 계좌 목록 ===
        bank.printAllAccounts();
        System.out.println();

        // === 예외 발생 테스트 ===
        try {
            bank.withdraw(acc2, 6000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        try {
            bank.withdraw(acc2, 7000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        try {
            bank.findAccount("AC9999");
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}
