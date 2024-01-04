package org.example.task2_2_ThreadLocal;

import java.util.concurrent.atomic.AtomicInteger;

public class ClientId {
    private static final ThreadLocal<AtomicInteger> counter = ThreadLocal.withInitial(AtomicInteger::new);
    private final int id;

    public ClientId() {
        this.id = counter.get().incrementAndGet();
    }

    public int getId() {
        return id;
    }
}
