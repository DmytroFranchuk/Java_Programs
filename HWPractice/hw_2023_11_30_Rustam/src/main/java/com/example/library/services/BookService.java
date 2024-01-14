package com.example.library.services;

import com.example.library.entity.BookEntity;
import com.example.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<BookEntity> booksByAuthor(Integer authorId) {
        return bookRepository.findByAuthorId(authorId);
    }

    public BookEntity earliestBook() {
        return bookRepository.findFirstByOrderByYearCreatAsc();
    }

    public List<BookEntity> booksBetweenYears(Integer startYear, Integer endYear) {
        return bookRepository.findByYearCreatBetween(startYear, endYear);
    }
}
