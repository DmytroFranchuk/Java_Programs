package org.example.dz_2023_11_07;

import java.util.Random;

import static java.util.Arrays.*;

public class MinMaxThreads extends Thread {
    private static final int ARRAY_SIZE = 10000;
    private static final int THREADS_COUNT = 2;
    private static int[] numbers = new int[ARRAY_SIZE];
    private static int minResult = Integer.MAX_VALUE;
    private static int maxResult = Integer.MIN_VALUE;

    public static void minMaxStart() {
        Random random = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            numbers[i] = random.nextInt(10001);
        }

        Thread[] threads = new Thread[THREADS_COUNT];
        threads[0] = new Thread(() -> MinMaxThreads.findMin(numbers));
        threads[1] = new Thread(() -> MinMaxThreads.findMax(numbers));

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Минимум: " + minResult);
        System.out.println("Максимум: " + maxResult);
    }

    private static int findMin(int[] arr) {
        int localMin = stream(arr).min().orElse(maxResult);
        synchronized (MinMaxThreads.class) {
            if (localMin < minResult) {
                minResult = localMin;
            }
        }
        return localMin;
    }

    private static int findMax(int[] arr) {
        int localMax = stream(arr).max().orElse(minResult);
        synchronized (MinMaxThreads.class) {
            if (localMax > maxResult) {
                maxResult = localMax;
            }
        }
        return localMax;
    }
}
