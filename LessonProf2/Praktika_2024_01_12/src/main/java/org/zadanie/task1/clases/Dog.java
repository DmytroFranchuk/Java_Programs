package org.zadanie.task1.clases;

import org.zadanie.task1.reflect.InvokeFirst;

public class Dog {
    private static final String NAME = Dog.class.getSimpleName() + ": ";
    @InvokeFirst
    public void sayBark() {
        System.out.println(NAME + "гавкает");
    }
    @InvokeFirst
    public void wagTail() {
        System.out.println(NAME + "виляет хвостом");
    }
    @InvokeFirst
    public void jump() {
        System.out.println(NAME + "прыгает");
    }

    public void sleep() {
        System.out.println(NAME + "спит");
    }


}
