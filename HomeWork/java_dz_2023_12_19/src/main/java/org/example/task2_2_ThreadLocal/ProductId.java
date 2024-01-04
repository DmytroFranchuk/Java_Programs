package org.example.task2_2_ThreadLocal;

import java.util.concurrent.atomic.AtomicInteger;

public class ProductId {
    private static final ThreadLocal<AtomicInteger> counter = ThreadLocal.withInitial(AtomicInteger::new);
    private final int id;

    public ProductId() {
        this.id = counter.get().incrementAndGet();
    }

    public int getId() {
        return id;
    }
}
