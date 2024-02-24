package com.example.demo.services;

import com.example.demo.entity.Journal;
import com.example.demo.repositories.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalService {

    private final JournalRepository journalRepository;

    @Autowired
    public JournalService(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    public Optional<Journal> getJournalById(Long id) {
        return journalRepository.findById(id);
    }


    public List<Journal> getAllJournals() {
        return journalRepository.findAll();
    }

    public Journal addJournal(Journal journal) {
        return journalRepository.save(journal);
    }

    public Optional<Journal> updateById(Long id, Journal updateJournal) {
        Optional<Journal> existingJournal = journalRepository.findById(id);
        if (existingJournal.isPresent()) {
            Journal journalToUpdate = existingJournal.get();
            journalToUpdate.setClassName(updateJournal.getClassName());
            journalToUpdate.setStudentFullName(updateJournal.getStudentFullName());
            journalToUpdate.setSubject(updateJournal.getSubject());
            journalToUpdate.setScore(updateJournal.getScore());
            journalToUpdate.setDate(updateJournal.getDate());
            return Optional.of(journalRepository.save(journalToUpdate));
        } else {
            return Optional.empty();
        }
    }

    public void deleteById(Long id) {
        Optional<Journal> optionalJournal = journalRepository.findById(id);
        optionalJournal.ifPresent(journalRepository::delete);
    }

    public List<Journal> getGradesByClassName(String className) {
        return journalRepository.findByClassName(className);
    }

    public List<Journal> getGradesByClassNameAndStudentFullName(String className, String studentFullName) {
        return journalRepository.findByClassNameAndStudentFullName(className, studentFullName);
    }


}
