package org.example.ThreadLocalExample_forTask2.exp2;

public class Exp2 {
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        threadLocal.set("hello world");
        Thread one = new ThreadOne();
        Thread two = new ThreadTwo();
        one.start();
        two.start();
        one.join();
        two.join();
        System.out.println("Main: " + threadLocal.get());
    }
    static class ThreadOne extends Thread {
        @Override
        public void run() {
            threadLocal.set("Thread_One");
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ThreadOne: " + threadLocal.get());
        }
    }

    static class ThreadTwo extends Thread {
        @Override
        public void run() {
            threadLocal.set("Thread_Two");
            System.out.println("ThreadTwo: " + threadLocal.get());
        }
    }
}
