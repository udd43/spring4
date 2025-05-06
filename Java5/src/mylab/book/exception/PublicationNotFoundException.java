package mylab.book.exception;

/**
 * 요청한 제목의 Publication(출판물)이 존재하지 않을 때 던지는 예외 클래스
 */
public class PublicationNotFoundException extends Exception {
    public PublicationNotFoundException(String message) {
        super(message);
    }
}
