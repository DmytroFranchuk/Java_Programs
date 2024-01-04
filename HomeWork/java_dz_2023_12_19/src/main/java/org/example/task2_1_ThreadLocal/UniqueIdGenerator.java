package org.example.task2_1_ThreadLocal;

import java.util.concurrent.atomic.AtomicInteger;

public class UniqueIdGenerator<T> implements Runnable {
    private static final ThreadLocal<AtomicInteger> counter = ThreadLocal.withInitial(AtomicInteger::new);
    private final Class<T> objectType;
    private final int count;

    public UniqueIdGenerator(Class<T> objectType, int count) {
        this.objectType = objectType;
        this.count = count;
    }

    public int generateUniqueId() {
        return counter.get().incrementAndGet();
    }

    @Override
    public void run() {
        for (int i = 1; i <= count; i++) {
            System.out.printf("%-7s %s generated ID: %s%n", objectType.getSimpleName(), i, generateUniqueId());
        }
    }
}
