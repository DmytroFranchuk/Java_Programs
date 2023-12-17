package org.example.task3;

// 3 Разработайте программу, использующую ConcurrentMap, для обеспечения безопасного
// обновления значения по условию. Например, уменьшайте значение ключа "stock" на 1
// только если текущее значение больше 0.

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class Task3 {
    private static final int NUMBEROFTHREADS = 10;
    private static final int COUNTKEYSTOCK = 10;

    public static void main(String[] args) {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("stock", COUNTKEYSTOCK);

        Thread[] threads = new Thread[NUMBEROFTHREADS];
        IntStream.range(0, NUMBEROFTHREADS)
                .forEach(i -> threads[i] = new Thread(() -> {
                    map.merge("stock", -1, (oldValue, valueToAdd) -> {
                        if (oldValue > 0) {
                            return oldValue + valueToAdd;
                        } else {
                            return oldValue;
                        }
                    });
                    System.out.println(Thread.currentThread().getName() + " обновленное значение: " + map.get("stock"));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }));
        Arrays.stream(threads)
                .forEach(Thread::start);
    }
}
