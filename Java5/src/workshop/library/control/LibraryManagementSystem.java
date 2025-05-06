package workshop.library.control;

import workshop.library.entity.Book;
import workshop.library.entity.Library;

import java.util.List;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Library library = new Library("�߾� ������");

        addSampleBooks(library);
        printLibraryInfo(library);

        testFindBook(library);
        testCheckOut(library, "978-89-01-14077-4");  // �ڹ��� ����
        testReturn(library, "978-89-01-14077-4");
        displayAvailableBooks(library);
    }

    private static void addSampleBooks(Library library) {
        library.addBook(new Book("�ڹ� ���α׷���", "���ڹ�", "978-89-01-12345-6", 2022));
        library.addBook(new Book("��ü������ ��ǰ� ����", "����ȣ", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("�ڹ��� ����", "���ü�", "978-89-01-14077-4", 2019));
        System.out.println();
    }

    private static void printLibraryInfo(Library lib) {
        System.out.println("===== " + lib.getName() + " =====");
        System.out.println("��ü ���� ��: " + lib.getTotalBooks());
        System.out.println("���� ���� ���� ��: " + lib.getAvailableBooksCount());
        System.out.println("���� ���� ���� ��: " + lib.getBorrowedBooksCount());
        System.out.println();
    }

    private static void testFindBook(Library lib) {
        System.out.println("===== ���� �˻� �׽�Ʈ =====");

        System.out.println("�������� �˻� ���:");
        Book byTitle = lib.findBookByTitle("�ڹ��� ����");
        System.out.println(byTitle != null ? byTitle : "�˻� ����� �����ϴ�.");
        System.out.println();

        System.out.println("���ڷ� �˻� ���:");
        List<Book> byAuthor = lib.findBooksByAuthor("Robert C. Martin");
        if (byAuthor.isEmpty()) {
            System.out.println("�˻� ����� �����ϴ�.");
        } else {
            byAuthor.forEach(System.out::println);
        }
        System.out.println();
    }

    private static void testCheckOut(Library lib, String isbn) {
        System.out.println("===== ���� ���� �׽�Ʈ =====");
        if (lib.checkOutBook(isbn)) {
            System.out.println("���� ���� ����!");
            System.out.println("����� ���� ����:");
            System.out.println(lib.findBookByISBN(isbn));
        } else {
            System.out.println("���⿡ �����߽��ϴ�.");
        }
        System.out.println();
        printLibraryInfo(lib);
    }

    private static void testReturn(Library lib, String isbn) {
        System.out.println("===== ���� �ݳ� �׽�Ʈ =====");
        if (lib.returnBook(isbn)) {
            System.out.println("���� �ݳ� ����!");
            System.out.println("�ݳ��� ���� ����:");
            System.out.println(lib.findBookByISBN(isbn));
        } else {
            System.out.println("�ݳ��� �����߽��ϴ�.");
        }
        System.out.println();
        printLibraryInfo(lib);
    }

    private static void displayAvailableBooks(Library lib) {
        System.out.println("===== ���� ������ ���� ��� =====");
        for (Book b : lib.getAvailableBooks()) {
            System.out.println(b);
            System.out.println("------------------------");
        }
    }
}
