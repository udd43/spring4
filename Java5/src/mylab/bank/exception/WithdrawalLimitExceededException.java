package mylab.bank.exception;

/**
 * ��� �ѵ� �ʰ� �� �߻�.
 * InsufficientBalanceException�� ����Ͽ� �ܾ� ���� ���ܿ� ���� ī�װ��� ó�� ����.
 */
public class WithdrawalLimitExceededException extends InsufficientBalanceException {
    public WithdrawalLimitExceededException(String message) {
        super(message);
    }
}
