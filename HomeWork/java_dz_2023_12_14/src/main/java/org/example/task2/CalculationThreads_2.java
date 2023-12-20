package org.example.task2;

// Создайте 10 потоков, каждый из которых «делает вычисления» (генерирует случайное
// число, ждёт сгенерированное число миллисекунд, добавляет сгенерированное число в
// общую для всех потоков переменную). Используя AtomicBoolean, создайте флаг,
// указывающий на возможность завершения приложения. Когда потоки накопят в общей
// переменной число 1_000_000 флаг становится true

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CalculationThreads_2 {
    public static void main(String[] args) {

        AtomicBoolean flag = new AtomicBoolean(false);
        AtomicInteger sharedVariable = new AtomicInteger(0);

        Thread[] threads = IntStream.range(0, 10)
                .mapToObj(e -> new Thread(() -> {
                    int currentValue = 0;
                    while (!flag.get()) {
                        int generatedNumber = doGeneration(800, 3_200);
                        if (currentValue >= 100_000) {
                            flag.set(true);
                        } else {currentValue = sharedVariable.addAndGet(generatedNumber);}
                    }
                }))
                .peek(Thread::start)
                .toArray(Thread[]::new);
        Arrays.stream(threads)
                .forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
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