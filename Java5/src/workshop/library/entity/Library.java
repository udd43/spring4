package workshop.library.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    /** 도서 추가 */
    public void addBook(Book book) {
        books.add(book);
        System.out.println("도서가 추가되었습니다: " + book.getTitle());
    }

    /** 제목으로 단일 도서 검색 */
    public Book findBookByTitle(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    /** 저자로 복수 도서 검색 */
    public List<Book> findBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                result.add(b);
            }
        }
        return result;
    }

    /** ISBN으로 단일 도서 검색 */
    public Book findBookByISBN(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                return b;
            }
        }
        return null;
    }

    /** ISBN 기준으로 대출 시도 */
    public boolean checkOutBook(String isbn) {
        Book b = findBookByISBN(isbn);
        return b != null && b.checkOut();
    }

    /** ISBN 기준으로 반납 처리 */
    public boolean returnBook(String isbn) {
        Book b = findBookByISBN(isbn);
        if (b != null) {
            b.returnBook();
            return true;
        }
        return false;
    }

    /** 대출 가능한 도서 목록 반환 */
    public List<Book> getAvailableBooks() {
        return books.stream()
                    .filter(Book::isAvailable)
                    .collect(Collectors.toList());
    }

    /** 전체 도서 목록 반환 */
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    /** 전체 도서 수 */
    public int getTotalBooks() {
        return books.size();
    }

    /** 대출 가능한 도서 수 */
    public int getAvailableBooksCount() {
        return (int) books.stream().filter(Book::isAvailable).count();
    }

    /** 대출 중인 도서 수 */
    public int getBorrowedBooksCount() {
        return getTotalBooks() - getAvailableBooksCount();
    }

    public String getName() {
        return name;
    }
}
