package mylab.bank.entity;

public class SavingsAccount extends Account {
    private double interestRate; // 연 이자율(%)

    public SavingsAccount(String accountNumber, String ownerName,
                          double initialBalance, double interestRate) {
        super(accountNumber, ownerName, initialBalance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    /**
     * 이자를 계산하여 계좌에 입금
     */
    public void applyInterest() {
        double interest = getBalance() * interestRate / 100.0;
        deposit(interest);
        System.out.printf("이자 %.1f원이 적용되었습니다. 현재 잔액: %.1f원%n",
                interest, getBalance());
    }

    @Override
    public String toString() {
        return super.toString() +
               String.format(", 이자율: %.1f%%", interestRate);
    }
}
