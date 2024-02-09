package org.zadanie.task1.clases;

import org.zadanie.task1.reflect.InvokeFirst;

public class Relative {
    private static final String NAME = Relative.class.getSimpleName() + ": ";

    public void congratulate() {
        System.out.println(NAME + "поздравить");
    }
    @InvokeFirst
    public void sayHi() {
        System.out.println(NAME + "поздоровался");
    }
    @InvokeFirst
    public void hug() {
        System.out.println(NAME + "обнял");
    }

    public void borrow() {
        System.out.println(NAME + "занять чего нибудь");
    }


}
