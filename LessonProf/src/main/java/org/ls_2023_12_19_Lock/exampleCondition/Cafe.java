package org.ls_2023_12_19_Lock.exampleCondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cafe {
    private final int totalSeats;
    private int availableSeats;
    private final Lock lock;
    private final Condition condition;

    public Cafe(int totalSeats) {
        this.totalSeats = totalSeats;
        availableSeats = totalSeats;
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    public void enter(String name) {
        lock.lock();
        try {
            while (availableSeats <= 0) {
                System.out.println(name + " ожидает новых клиентов");
                try {
                condition.await();
            } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Клиент " + name + " пришел");
            availableSeats--;
        } finally {
            lock.unlock();
        }
    }

    public void escape(String name){
        lock.lock();
        try {
            System.out.println(name +" Клиент " + name + " ушел довольный и сытый");
            availableSeats++;
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}
