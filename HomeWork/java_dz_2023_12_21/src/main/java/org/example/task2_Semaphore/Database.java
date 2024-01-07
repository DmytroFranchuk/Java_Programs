package org.example.task2_Semaphore;

import java.util.concurrent.Semaphore;

public class Database {
    private final Semaphore semaphore;

    public Database(int permits) {
        semaphore = new Semaphore(permits);
    }

    public void writeToDatabase() {
        try {
            semaphore.acquire();
            System.out.println("Запись в базу данных производится потоком: " + Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
