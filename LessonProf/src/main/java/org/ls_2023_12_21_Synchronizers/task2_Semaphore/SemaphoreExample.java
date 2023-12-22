package org.ls_2023_12_21_Synchronizers.task2_Semaphore;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;

// jЕсть файловый ресурс, который может обрабатывать ограниченное количество одновременных запросов.
// Используйте Semaphore, чтобы ограничить количество потоков, которые могут одновременно обращаться
// к файловому ресурсу.

public class SemaphoreExample {
    private static final Semaphore SEMAFORE = new Semaphore(3, true);
    public static void main(String[] args) {
        List<Thread> threads = Arrays.stream(new int[125]).mapToObj(i -> new Thread(() -> {
                    try {
                        SEMAFORE.acquire();
                        System.out.println(Thread.currentThread().getId() + " получил доступ к файлу ");
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        SEMAFORE.release();
                        System.out.println(Thread.currentThread().getId() + " закончил работу с файлом ");
                    }
        }))
                .peek(Thread::start)
                .toList();
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
