package mylab.bank.entity;

public class SavingsAccount extends Account {
    private double interestRate; // �� ������(%)

    public SavingsAccount(String accountNumber, String ownerName,
                          double initialBalance, double interestRate) {
        super(accountNumber, ownerName, initialBalance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    /**
     * ���ڸ� ����Ͽ� ���¿� �Ա�
     */
    public void applyInterest() {
        double interest = getBalance() * interestRate / 100.0;
        deposit(interest);
        System.out.printf("���� %.1f���� ����Ǿ����ϴ�. ���� �ܾ�: %.1f��%n",
                interest, getBalance());
    }

    @Override
    public String toString() {
        return super.toString() +
               String.format(", ������: %.1f%%", interestRate);
    }
}
