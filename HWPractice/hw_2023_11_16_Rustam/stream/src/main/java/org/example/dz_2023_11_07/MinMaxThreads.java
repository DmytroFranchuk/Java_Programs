package org.example.dz_2023_11_07;

import java.util.Random;

import static java.util.Arrays.*;

public class MinMaxThreads {
    private static final int ARRAY_SIZE = 10000;
    private static int[] numbers = new int[ARRAY_SIZE];

    public MinMaxThreads() {
        Random rd = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            numbers[i] = rd.nextInt(10001);
        }
    }

    public void minMaxStart() throws InterruptedException {
        Thread maxThread = new Thread(() -> {
            int max = findMax(numbers);
            System.out.println("Максимум: " + max);
        });
        Thread minThread = new Thread(() -> {
            int min = findMin(numbers);
            System.out.println("Минимум: " + min);
        });
        maxThread.start();
        minThread.start();
        maxThread.join();
        minThread.join();
    }

    public int findMax(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i : array) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public int findMin(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i : array) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }
}

