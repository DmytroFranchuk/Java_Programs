package org.example.ThreadLocalExample_forTask2.exp1;

public class Exp1 {
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo threadDemo = new ThreadDemo();

        Thread t1 = new Thread(threadDemo);
        Thread t2 = new Thread(threadDemo);
        Thread t3 = new Thread(threadDemo);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
}