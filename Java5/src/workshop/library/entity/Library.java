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

    /** ���� �߰� */
    public void addBook(Book book) {
        books.add(book);
        System.out.println("������ �߰��Ǿ����ϴ�: " + book.getTitle());
    }

    /** �������� ���� ���� �˻� */
    public Book findBookByTitle(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    /** ���ڷ� ���� ���� �˻� */
    public List<Book> findBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                result.add(b);
            }
        }
        return result;
    }

    /** ISBN���� ���� ���� �˻� */
    public Book findBookByISBN(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                return b;
            }
        }
        return null;
    }

    /** ISBN �������� ���� �õ� */
    public boolean checkOutBook(String isbn) {
        Book b = findBookByISBN(isbn);
        return b != null && b.checkOut();
    }

    /** ISBN �������� �ݳ� ó�� */
    public boolean returnBook(String isbn) {
        Book b = findBookByISBN(isbn);
        if (b != null) {
            b.returnBook();
            return true;
        }
        return false;
    }

    /** ���� ������ ���� ��� ��ȯ */
    public List<Book> getAvailableBooks() {
        return books.stream()
                    .filter(Book::isAvailable)
                    .collect(Collectors.toList());
    }

    /** ��ü ���� ��� ��ȯ */
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    /** ��ü ���� �� */
    public int getTotalBooks() {
        return books.size();
    }

    /** ���� ������ ���� �� */
    public int getAvailableBooksCount() {
        return (int) books.stream().filter(Book::isAvailable).count();
    }

    /** ���� ���� ���� �� */
    public int getBorrowedBooksCount() {
        return getTotalBooks() - getAvailableBooksCount();
    }

    public String getName() {
        return name;
    }
}
