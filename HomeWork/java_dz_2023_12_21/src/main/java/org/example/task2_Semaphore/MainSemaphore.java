package org.example.task2_Semaphore;

public class MainSemaphore {
    public static void main(String[] args) {
        final int THREADS_COUNT = 5;
        Database database = new Database(2);
        for (int i = 0; i < THREADS_COUNT; i++) {
            Thread thread = new Thread(() -> {
                database.writeToDatabase();
            });
            thread.start();
        }
    }
}
