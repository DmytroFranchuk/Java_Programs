package org.lesson_Reflection.lesson_materials.person;

import java.io.Serializable;

public class Person implements Serializable, Comparable<Person> {
    public static final String DEFAULT_NAME = "Default";
    private String name;
    private int age;

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Empty name");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + '\'' + ", age=" + age + '}';
    }

    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.name);
    }
}
