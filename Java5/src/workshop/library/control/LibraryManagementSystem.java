package workshop.library.control;

import workshop.library.entity.Book;
import workshop.library.entity.Library;

import java.util.List;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Library library = new Library("중앙 도서관");

        addSampleBooks(library);
        printLibraryInfo(library);

        testFindBook(library);
        testCheckOut(library, "978-89-01-14077-4");  // 자바의 정석
        testReturn(library, "978-89-01-14077-4");
        displayAvailableBooks(library);
    }

    private static void addSampleBooks(Library library) {
        library.addBook(new Book("자바 프로그래밍", "김자바", "978-89-01-12345-6", 2022));
        library.addBook(new Book("객체지향의 사실과 오해", "조영호", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("자바의 정석", "남궁성", "978-89-01-14077-4", 2019));
        System.out.println();
    }

    private static void printLibraryInfo(Library lib) {
        System.out.println("===== " + lib.getName() + " =====");
        System.out.println("전체 도서 수: " + lib.getTotalBooks());
        System.out.println("대출 가능 도서 수: " + lib.getAvailableBooksCount());
        System.out.println("대출 중인 도서 수: " + lib.getBorrowedBooksCount());
        System.out.println();
    }

    private static void testFindBook(Library lib) {
        System.out.println("===== 도서 검색 테스트 =====");

        System.out.println("제목으로 검색 결과:");
        Book byTitle = lib.findBookByTitle("자바의 정석");
        System.out.println(byTitle != null ? byTitle : "검색 결과가 없습니다.");
        System.out.println();

        System.out.println("저자로 검색 결과:");
        List<Book> byAuthor = lib.findBooksByAuthor("Robert C. Martin");
        if (byAuthor.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
        } else {
            byAuthor.forEach(System.out::println);
        }
        System.out.println();
    }

    private static void testCheckOut(Library lib, String isbn) {
        System.out.println("===== 도서 대출 테스트 =====");
        if (lib.checkOutBook(isbn)) {
            System.out.println("도서 대출 성공!");
            System.out.println("대출된 도서 정보:");
            System.out.println(lib.findBookByISBN(isbn));
        } else {
            System.out.println("대출에 실패했습니다.");
        }
        System.out.println();
        printLibraryInfo(lib);
    }

    private static void testReturn(Library lib, String isbn) {
        System.out.println("===== 도서 반납 테스트 =====");
        if (lib.returnBook(isbn)) {
            System.out.println("도서 반납 성공!");
            System.out.println("반납된 도서 정보:");
            System.out.println(lib.findBookByISBN(isbn));
        } else {
            System.out.println("반납에 실패했습니다.");
        }
        System.out.println();
        printLibraryInfo(lib);
    }

    private static void displayAvailableBooks(Library lib) {
        System.out.println("===== 대출 가능한 도서 목록 =====");
        for (Book b : lib.getAvailableBooks()) {
            System.out.println(b);
            System.out.println("------------------------");
        }
    }
}
