package com.example.demo.controllers;

import com.example.demo.entity.Journal;
import com.example.demo.services.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/journals")
public class JournalController {
    private final JournalService journalService;

    @Autowired
    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Journal> getJournalById(@PathVariable Long id) {
        Optional<Journal> journal = journalService.getJournalById(id);
        return journal.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/gradesByClass/{className}")
    public ResponseEntity<List<Journal>> getGradesByClassName(@PathVariable String className) {
        List<Journal> grades = journalService.getGradesByClassName(className);
        return new ResponseEntity<>(grades, HttpStatus.OK);
    }

    @GetMapping("/gradesByStudent/{className}/{studentFullName}")
    public ResponseEntity<List<Journal>> getGradesByClassNameAndStudentFullName(
            @PathVariable String className,
            @PathVariable String studentFullName) {
        List<Journal> grades = journalService.getGradesByClassNameAndStudentFullName(className, studentFullName);
        return new ResponseEntity<>(grades, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<Journal>> getAllJournals() {
        List<Journal> journals = journalService.getAllJournals();
        return new ResponseEntity<>(journals, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Journal> addJournal(@RequestBody Journal journal) {
        Journal createdJournal = journalService.addJournal(journal);
        return new ResponseEntity<>(createdJournal, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Journal> updateJournal(@PathVariable Long id, @RequestBody Journal updateJournal) {
        return journalService.updateById(id, updateJournal)
                .map(journal -> new ResponseEntity<>(journal, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJournal(@PathVariable Long id) {
        journalService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
