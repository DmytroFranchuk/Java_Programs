package UnitTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Library library;
    private static final Book MY_BOOK = new Book("Гарри Поттер и кубок огня", "Роулинг", 2000);

    @BeforeEach
    void setUp() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Властилин колец", "Толкин", 1954));
        books.add(new Book("Гордость и предубеждения", "Остин", 1813));
        books.add(MY_BOOK);
        books.add(new Book("1984", "Оруэл", 1949));
        books.add(new Book("Убить пересмешника", "Ли", 1960));
        library = new Library(books);
    }

    @AfterEach
    void tearDown() {
        library = null;
    }

    @Test
    void addBookTest() {
        library.addBook(new Book("Гарри Поттер и орден Феникса", "Роулинг", 2007));
        assertEquals(6, library.getBooks().size());
    }

    @Test
    void removeBookTest() {
        library.removeBook(MY_BOOK);
        assertEquals(4, library.getBooks().size());
    }

    @Test
    void searchByAuthorTest() {
        List<Book> expected = new ArrayList<>();
        expected.add(MY_BOOK);
        assertEquals(expected, library.searchByAuthor(MY_BOOK.getAuthor()));
    }

    @Test
    void searchByTitleTest() {
        List<Book> expected = new ArrayList<>();
        expected.add(MY_BOOK);
        assertEquals(expected, library.searchByTitle(MY_BOOK.getTitle()));
    }

    @Test
    void searchByYearTest() {
        List<Book> expected = new ArrayList<>();
        expected.add(MY_BOOK);
        assertEquals(expected, library.searchByYear(MY_BOOK.getYear()));
    }
}