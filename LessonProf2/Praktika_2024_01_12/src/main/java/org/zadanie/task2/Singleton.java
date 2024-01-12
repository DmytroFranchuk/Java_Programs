package org.zadanie.task2;

import java.io.Serial;
import java.io.Serializable;
import java.util.Optional;

public class Singleton implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private static Singleton instance;

    private Singleton() {
    }

//    public static Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }

    public static Singleton getInstance() {
       return instance = (instance != null) ? instance : new Singleton();
    }

//    public static Singleton getInstance() {
//        return instance = Optional.ofNullable(instance).orElse(new Singleton());
//    }
}
