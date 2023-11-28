package org.ls_2023_11_09_mockitoTest.praktika.tasks.taski;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Library {
    private Set<Book> books;
    private List<Author> authors;

    public Library() {
        this.books = new HashSet<>();
        this.authors = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        books.add(book);
        if (!authors.contains(book.getAuthor())) {
            authors.add(book.getAuthor());
        }
    }

    public void removeBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        books.remove(book);
    }

    public List<Book> getBooksByAuthor(Author author) {
        return books.stream().
                filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    public List<Author> getAllAuthors() {
        return new ArrayList<>(authors);
    }

    public Book findBookByISBN(String isbn) {
        return books.stream().
                filter(book -> book.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    public List<Book> searchBooksByTitle(String title) {
        return books.stream().
                filter(book -> book.getTitle().toLowerCase()
                        .contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void addCopies(Book book, int additionalCopies) {
        if (!books.contains(book)) {
            throw new IllegalArgumentException("Book is not in the library");
        }
        book.setCopies(book.getCopies() + additionalCopies);
    }

    public void lendBook(Book book) {
        if (!books.contains(book) || book.getCopies() <= 0) {
            throw new IllegalArgumentException("Book is not available");
        }
        book.setCopies(book.getCopies() - 1);
    }

    public void returnBook(Book book) {
        if (!books.contains(book)) {
            throw new IllegalArgumentException("Book is not from this library");
        }
        book.setCopies(book.getCopies() + 1);
    }
}