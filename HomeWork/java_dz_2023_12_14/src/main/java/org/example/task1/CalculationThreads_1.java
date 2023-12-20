package org.example.task1;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

// Создайте 10 потоков, каждый из которых «делает вычисления» (генерирует случайное
// число, ждёт сгенерированное число миллисекунд, добавляет сгенерированное число в
// общую для всех потоков переменную). Используя AtomicBoolean, создайте флаг,
// указывающий на возможность завершения приложения. Когда потоки накопят в общей
// переменной число 1_000_000 флаг становится true

public class CalculationThreads_1 {
    public static void main(String[] args) {

        AtomicBoolean flag = new AtomicBoolean(false);
        AtomicInteger sharedVariable = new AtomicInteger(0);
        List<Integer> listValues = new CopyOnWriteArrayList<>();
        Thread[] threads = new Thread[0];
        int delta = 0;

        while (!flag.get()) {
            threads = IntStream.range(0, 10)
                    .mapToObj(e -> new Thread(() -> {
                        listValues.add(doGeneration(800, 3_200));
                    }))
                    .peek(Thread::start)
                    .toArray(Thread[]::new);
            for (int i = delta; i < listValues.size(); i++) {
                if (sharedVariable.get() < 100_000) {
                    sharedVariable.addAndGet(listValues.get(i));
                } else {
                    sharedVariable.set(100_000);
                    flag.set(true);
                }
                delta++;
            }
            Arrays.stream(threads)
                    .forEach(thread -> {
                        try {
                            thread.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
        }

        System.out.println("Значение переменной достигло: " + sharedVariable);
        System.out.println("Окончание программы");
    }

    private static int doGeneration(int start, int end) {
        int value = ThreadLocalRandom.current().nextInt(start, (end + 1));
        System.out.println(Thread.currentThread().getName() + " сгенерировал число: " + value);
        try {
            Thread.sleep(value);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return value;
    }
}
