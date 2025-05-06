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
     * 저축 계좌 생성
     */
    public String createSavingsAccount(String ownerName,
                                       double initialBalance,
                                       double interestRate) {
        String acctNo = "AC" + nextAccountNumber++;
        SavingsAccount sa = new SavingsAccount(acctNo, ownerName, initialBalance, interestRate);
        accounts.add(sa);
        System.out.printf(
            "Saving(저축) 계좌가 생성되었습니다: 계좌번호: %s, 소유자: %s, 잔액: %.1f원, 이자율: %.1f%%%n",
            acctNo, ownerName, initialBalance, interestRate);
        return acctNo;
    }

    /**
     * 체킹 계좌 생성
     */
    public String createCheckingAccount(String ownerName,
                                        double initialBalance,
                                        double withdrawalLimit) {
        String acctNo = "AC" + nextAccountNumber++;
        CheckingAccount ca = new CheckingAccount(acctNo, ownerName, initialBalance, withdrawalLimit);
        accounts.add(ca);
        System.out.printf(
            "체킹 계좌가 생성되었습니다: 계좌번호: %s, 소유자: %s, 잔액: %.1f원, 출금 한도: %.1f원%n",
            acctNo, ownerName, initialBalance, withdrawalLimit);
        return acctNo;
    }

    /**
     * 계좌 조회
     */
    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        return accounts.stream()
            .filter(a -> a.getAccountNumber().equals(accountNumber))
            .findFirst()
            .orElseThrow(() ->
                new AccountNotFoundException(
                    String.format("계좌번호 %s에 해당하는 계좌를 찾을 수 없습니다.", accountNumber))
            );
    }

    /**
     * 입금
     */
    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        Account acc = findAccount(accountNumber);
        acc.deposit(amount);
        System.out.printf("%.1f원이 입금되었습니다. 현재 잔액: %.1f원%n",
                          amount, acc.getBalance());
    }

    /**
     * 출금
     */
    public void withdraw(String accountNumber, double amount)
            throws AccountNotFoundException, InsufficientBalanceException, WithdrawalLimitExceededException {
        Account acc = findAccount(accountNumber);
        // CheckingAccount 의 withdraw() 가 한도 및 잔액 검사
        if (acc instanceof CheckingAccount) {
            ((CheckingAccount) acc).withdraw(amount);
        } else {
            if (amount > acc.getBalance()) {
                throw new InsufficientBalanceException(
                    String.format("잔액이 부족합니다. 현재 잔액: %.1f원", acc.getBalance()));
            }
            acc.withdraw(amount);
        }
        System.out.printf("%.1f원이 출금되었습니다. 현재 잔액: %.1f원%n",
                          amount, acc.getBalance());
    }

    /**
     * 송금 (출금 + 입금)
     */
    public void transfer(String fromAccount, String toAccount, double amount)
            throws AccountNotFoundException, InsufficientBalanceException, WithdrawalLimitExceededException {
        withdraw(fromAccount, amount);
        deposit(toAccount, amount);
        System.out.printf("%.1f원이 %s에서 %s로 송금되었습니다.%n",
                          amount, fromAccount, toAccount);
    }

    /**
     * 모든 계좌 출력
     */
    public void printAllAccounts() {
        System.out.println("=== 모든 계좌 목록 ===");
        accounts.forEach(a -> System.out.println(a));
        System.out.println("====================");
    }
}

