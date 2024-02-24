package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Entity
public class JournalEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String className;
    private String studentFullName;
    private String subject;
    private int score;
    private LocalDate date;

    public JournalEntry(Long id, String className, String studentFullName, String subject, int score, LocalDate date) {
        this.id = id;
        this.className = className;
        this.studentFullName = studentFullName;
        this.subject = subject;
        this.score = score;
        this.date = date;
    }

    public JournalEntry() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JournalEntry that = (JournalEntry) o;
        return score == that.score && Objects.equals(id, that.id) && Objects.equals(className, that.className) && Objects.equals(studentFullName, that.studentFullName) && Objects.equals(subject, that.subject) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, className, studentFullName, subject, score, date);
    }

    @Override
    public String toString() {
        return "\nJournalEntry{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", studentFullName='" + studentFullName + '\'' +
                ", subject='" + subject + '\'' +
                ", score=" + score +
                ", date=" + date +
                '}';
    }
}
