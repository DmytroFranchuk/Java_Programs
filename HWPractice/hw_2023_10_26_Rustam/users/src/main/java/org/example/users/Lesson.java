package org.example.users;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Lesson {
    LocalDateTime dateTimeLesson;
    List<Student> students;

    public Lesson(LocalDateTime dateTimeLesson) {
        this.dateTimeLesson = dateTimeLesson;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void removeStudent(Student student){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i) == student) students.remove(i);
            return;
        }
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "dateTimeLesson=" + dateTimeLesson +
                ", students=" + students +
                '}';
    }
}
