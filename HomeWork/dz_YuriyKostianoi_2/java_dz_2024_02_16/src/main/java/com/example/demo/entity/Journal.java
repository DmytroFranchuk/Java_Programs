package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "journals")
public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "class_name")
    private String className;

    @Column(name = "student_full_name")
    private String studentFullName;

    @Column(name = "subject")
    private String subject;

    @Column(name = "score")
    private Integer score;

    @Column(name = "date")
    private LocalDate date;

    @Override
    public String toString() {
        return "\nJournal{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", studentFullName='" + studentFullName + '\'' +
                ", subject='" + subject + '\'' +
                ", score=" + score +
                ", date=" + date +
                '}';
    }
}
