package org.example.task3.subject.student;

import org.example.task3.subject.Subject;

public class Student<T extends Subject> {
    private T subject;

    public Student(T subject) {
        this.subject = subject;
    }

    public T getSubject() {
        return subject;
    }
}
