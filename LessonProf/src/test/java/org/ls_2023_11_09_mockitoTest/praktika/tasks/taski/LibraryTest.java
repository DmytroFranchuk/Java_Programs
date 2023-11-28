package org.ls_2023_11_09_mockitoTest.praktika.tasks.taski;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LibraryTest {
    Author author1 = new Author("Барри Берд", 1978);
    Author author2 = new Author("Кей Хорстманн", 1971);
    Book bookJava1 = new Book("Java для чайников", author1, "978-5-8459-1769-0", 2012);
    Book bookJava2 = new Book("Java. Библиотека профессионала", author2, " 978-5-907114-79-1", 2020);
    Library library = new Library();

    @Test
    @ExtendWith(MockitoExtension.class)
    void addBookTestException() {
        assertThrows(IllegalArgumentException.class, () -> library.addBook(null));
    }

    @Test
    void addBookTestMessageOfException() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> library.addBook(null));
        assertEquals("Book cannot be null", e.getMessage());
    }

    @Test
    void addBookTestUsingReflection() throws Exception {
        Field field = Library.class.getDeclaredField("books");
        field.setAccessible(true);
        Set<Book> books = (Set<Book>) field.get(library);
        library.addBook(bookJava1);
        library.addBook(bookJava2);
        Book book = mock(Book.class);
        library.addBook(book);
        assertEquals(3, books.size());
    }

    @Test
    void addBookTestUsingReflection2() throws Exception {
        Field field = Library.class.getDeclaredField("books");
        field.setAccessible(true);
        Set<Book> books = (Set<Book>) field.get(library);
        library.addBook(bookJava1);
        library.addBook(bookJava1);
        assertEquals(1, books.size());
    }

    @Test
    void addBook() {
        Set<Book> books = spy(HashSet.class);
        Library library1 = new Library();
        ReflectionTestUtils.setField(library1, "books", books);
        library1.addBook(bookJava1);
        verify(books).add(bookJava1);
        library1.addBook(bookJava2);
        verify(books).add(bookJava2);
        assertEquals(2, books.size());
        library1.addBook(bookJava2);
        assertEquals(2, books.size());
    }

    @Test
    void addBookSameAuthor() {
        List<Author> authors = spy(ArrayList.class);
        Library library2 = new Library();
        ReflectionTestUtils.setField(library2, "authors", authors);
        library2.addBook(bookJava1);
        library2.addBook(bookJava2);
        assertEquals(2, authors.size());
        library2.addBook(bookJava2);
        assertEquals(2, authors.size());
    }

    @Test
    void removeBookTestBookOfNull() {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> library.removeBook(null));
        assertEquals("Book cannot be null", e.getMessage());
    }

    @Test
    void removeBookTest() {
        Set<Book> bookSpy = spy(HashSet.class);
        Library library1 = new Library();
        ReflectionTestUtils.setField(library1, "books", bookSpy);
        bookSpy.add(bookJava1);
        bookSpy.add(bookJava2);
        library1.removeBook(bookJava1);
        assertEquals(1, bookSpy.size());
    }



    @Test
    void getBooksByAuthor() {
    }

    @Test
    void getAllAuthorsTest() {
    }

    @Test
    void findBookByISBN() {
    }

    @Test
    void searchBooksByTitle() {
    }

    @Test
    void addCopies() {
    }

    @Test
    void lendBook() {
    }

    @Test
    void returnBook() {
    }
}