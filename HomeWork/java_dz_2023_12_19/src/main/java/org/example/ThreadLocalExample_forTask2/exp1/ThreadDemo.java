package org.example.ThreadLocalExample_forTask2.exp1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo implements Runnable {
    private final AtomicInteger counter = new AtomicInteger(1);
    private final ThreadLocal<Integer> threadLocalCounter = new ThreadLocal<>();
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSSSSSSSS");

    @Override
    public void run() {
        int count = counter.getAndIncrement();
        if (threadLocalCounter.get() == null) {
            threadLocalCounter.set(count);
        } else {
            threadLocalCounter.set(threadLocalCounter.get() + 1);
        }
        printCounters(count);
    }

    public void printCounters(int count) {
        System.out.printf("%s Counter: %s - %s%n", LocalDateTime.now().format(FORMATTER),
                Thread.currentThread().getId(), count);
        System.out.printf("%s threadLocalCounter: %s - %s%n", LocalDateTime.now().format(FORMATTER),
                Thread.currentThread().getId(), threadLocalCounter.get());
    }
}