package org.ls_2023_12_19_Lock.exampleCondition;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Cafe cafe = new Cafe(5);
        AtomicInteger id = new AtomicInteger(1);
        List<Thread> threads = Arrays.stream(new int[8])
                .mapToObj(e -> new Thread(() -> {
                    String name = "Visitor " + id.getAndIncrement();
                    System.out.println(name + " пытается войти в кафе");
                    cafe.enter(name);
                    System.out.println(name + " кушает в кафе");
                    try {
                        Thread.sleep(ThreadLocalRandom.current().nextInt(3000));
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    } finally {
                        cafe.escape(name);
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
