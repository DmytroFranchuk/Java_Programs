package org.ls_2023_12_19_Lock.ThreadPoolExecutor_Exp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {

    public static void main(String[] args) {
        // Создание ThreadPool с фиксированным числом потоков
        int numberOfThreads = 3;
        // создание сервисов исполнение происходит через утилитарный класс Executor.
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        // Подача задач на выполнение в ThreadPool
        for (int i = 0; i < 5; i++) {
            int taskNumber = i;
            executorService.execute(() -> {
                System.out.printf("Task %d is being processed by thread %s%n", taskNumber, Thread.currentThread().getName());
            });
        }

        // Завершение работы ThreadPool после завершения всех задач
        executorService.shutdown();
    }
}
