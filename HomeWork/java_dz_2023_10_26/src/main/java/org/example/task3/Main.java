package org.example.task3;

import org.example.task3.subject.exactSciences.ExactSciences;
import org.example.task3.subject.exactSciences.Mathematics;
import org.example.task3.subject.humanities.Humanities;
import org.example.task3.subject.humanities.Literature;
import org.example.task3.subject.naturalSciences.Biology;
import org.example.task3.subject.naturalSciences.Chemistry;
import org.example.task3.subject.naturalSciences.NaturalSciences;
import org.example.task3.subject.student.ExactSciencesStudent;
import org.example.task3.subject.student.HumanitiesStudent;
import org.example.task3.subject.student.NaturalSciencesStudent;

// Создайте иерархию учебных предметов (Subject -> Natural sciences/exact sciences/humanities ->
// Biology, Chemistry / Physics, Mathematics / Literature, Philology). Напишите класс Student,
// параметризируемый предметом. Создайте классы студентов по каждому из направлений
// (Natural sciences/exact sciences/humanities), укажите в наследуемом параметре конкретный тип направления.
public class Main {
    public static void main(String[] args) {
        NaturalSciencesStudent naturalSciencesStudent = new NaturalSciencesStudent(new Biology());
        NaturalSciences biology = naturalSciencesStudent.getSubject();
        System.out.println("Student studies Natural Sciences: " + biology.getClass().getSimpleName());

        ExactSciencesStudent exactSciencesStudent = new ExactSciencesStudent(new Mathematics());
        ExactSciences mathematics = exactSciencesStudent.getSubject();
        System.out.println("Student studies Exact Sciences: " + mathematics.getClass().getSimpleName());

        HumanitiesStudent humanitiesStudent = new HumanitiesStudent(new Literature());
        Humanities literature = humanitiesStudent.getSubject();
        System.out.println("Student studies Humanities: " + literature.getClass().getSimpleName());
    }


}
