package mylab.bank.exception;

/**
 * 출금 한도 초과 시 발생.
 * InsufficientBalanceException을 상속하여 잔액 부족 예외와 동일 카테고리로 처리 가능.
 */
public class WithdrawalLimitExceededException extends InsufficientBalanceException {
    public WithdrawalLimitExceededException(String message) {
        super(message);
    }
}
