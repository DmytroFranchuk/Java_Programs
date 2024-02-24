package com.example.demo.repositories;

import com.example.demo.entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JournalRepository extends JpaRepository<Journal, Long> {

    List<Journal> findByClassName(String className);
    List<Journal> findByClassNameAndStudentFullName(String className, String studentFullName);

}
