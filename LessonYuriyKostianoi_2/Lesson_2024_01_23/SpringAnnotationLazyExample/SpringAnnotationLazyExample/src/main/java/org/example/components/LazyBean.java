package org.example.components;

public class LazyBean {
    public LazyBean() {
        System.out.println("Создание бина " + this.getClass().getSimpleName());
    }
}
