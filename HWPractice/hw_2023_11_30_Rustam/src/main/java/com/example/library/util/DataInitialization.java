package com.example.library.util;

import com.example.library.entity.AuthorEntity;
import com.example.library.entity.BookEntity;
import com.example.library.repositories.AuthorRepository;
import com.example.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitialization implements CommandLineRunner {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        AuthorEntity author1 = new AuthorEntity("Александр", "Грибоедов");
        AuthorEntity author2 = new AuthorEntity("Лев", "Толстой");
        AuthorEntity author3 = new AuthorEntity("Михаил", "Лермонтов");
        AuthorEntity author4 = new AuthorEntity("Александр", "Пушкин");

        authorRepository.saveAll(List.of(author1, author2, author3, author4));

        BookEntity book1 = new BookEntity("Горе от ума", 1824, author1.getId());
        BookEntity book2 = new BookEntity("Война и мир", 1863, author2.getId());
        BookEntity book3 = new BookEntity("Мцыри", 1838, author3.getId());
        BookEntity book4 = new BookEntity("Евгений Онегин", 1833, author4.getId());

        bookRepository.saveAll(List.of(book1, book2, book3, book4));

        // Выполнение запросов
        System.out.println("Кто написал какую книгу?");
        authorRepository.findAll().forEach(author -> {
            System.out.println(author.getFirstNameAutor() + " " + author.getLastNameAutor() +
                    ": " + bookRepository.findByAuthorId(author.getId()));
        });

        System.out.println("\nКакая книга написана раньше всех?");
        System.out.println(bookRepository.findFirstByOrderByYearCreatAsc());

        System.out.println("\nКакие книги были написаны с 1800 по 1900?");
        bookRepository.findByYearCreatBetween(1800, 1900).forEach(System.out::println);

        System.out.println("\nКто из авторов написал больше всего книг?");
        authorRepository.findAll().forEach(author -> {
            System.out.println(author.getFirstNameAutor() + " " + author.getLastNameAutor() +
                    ": " + bookRepository.findByAuthorId(author.getId()).size() + " книг");
        });
//        System.exit(0);
    }
}
