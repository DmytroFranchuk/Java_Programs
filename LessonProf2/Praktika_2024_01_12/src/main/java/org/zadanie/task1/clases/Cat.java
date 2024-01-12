package org.zadanie.task1.clases;

import org.zadanie.task1.reflect.InvokeFirst;

public class Cat {
    private static final String NAME = Cat.class.getSimpleName() + ": ";
    @InvokeFirst
    public void sayMew() {
        System.out.println(NAME + "сказал мяю");
    }
    @InvokeFirst
    public void purr() {
        System.out.println(NAME + "мурчит");
    }
    @InvokeFirst
    public void pub() {
        System.out.println(NAME + "трется");
    }

    public void sleep() {
        System.out.println(NAME + "спит");
    }


}
