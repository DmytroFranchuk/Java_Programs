package com.example.library.repositories;

import com.example.library.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    List<BookEntity> findByAuthorId(Integer authorId);
    List<BookEntity> findByYearCreatBetween(Integer startYear, Integer endYear);
    BookEntity findFirstByOrderByYearCreatAsc();
}
