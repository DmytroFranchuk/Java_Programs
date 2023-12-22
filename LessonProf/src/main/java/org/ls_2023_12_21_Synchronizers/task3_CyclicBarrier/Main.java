package org.ls_2023_12_21_Synchronizers.task3_CyclicBarrier;

import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

// В многопользовательской игре у каждого игрового персонажа есть различные этапы подготовки
// (например, загрузка ресурсов, инициализация). Используйте CyclicBarrier, чтобы синхронизировать
// старт игровых персонажей после завершения всех этапов подготовки.

public class Main {
    private static final int COUNT_PLAYERS = 3;
    private static final int COUNT_STAGE = 4;
    private static final CyclicBarrier BARRIER = new CyclicBarrier(COUNT_PLAYERS);

    public static void main(String[] args) {
        Arrays.stream(new int[COUNT_PLAYERS]).mapToObj(a -> new Thread(() -> {
            System.out.println(Thread.currentThread().getId() + " начал подготовку ...");
            for (int i = 0; i < COUNT_STAGE; i++) {
                System.out.println(Thread.currentThread().getId() + " проходит стадию подготовки " + i);
                try {
                    BARRIER.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getId() + " подготовлен к игре");
        })).forEach(Thread::start);
    }
}
