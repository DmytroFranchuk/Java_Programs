package org.example;

import org.example.users.Lesson;
import org.example.users.Student;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class task1 {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
        Student student1 = new Student(2004, "Ivan","Pupkin");
        Student student2 = new Student(2003, "Karina", "Dorn");

        Lesson lesson = new Lesson(LocalDateTime.of(2024,1,6, 9,30));

        lesson.addStudent(student1);
        lesson.addStudent(student2);

        System.out.println(lesson);

        lesson.removeStudent(student1);
        System.out.println(lesson);

    }
}
