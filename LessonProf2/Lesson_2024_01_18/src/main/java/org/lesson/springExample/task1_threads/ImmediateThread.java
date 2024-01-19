package org.lesson.springExample.task1_threads;

public class ImmediateThread extends Thread {
    @Override
    public void run() {
        System.out.println("Поток запущен");
    }

    public void immediateStart() {
        System.out.println("Выполняется метод immediateStart");
        this.start();
    }

    public void immediateInterrupt() {
        System.out.println("Выполняется метод immediateInterrupt");
        this.interrupt();
    }
}
