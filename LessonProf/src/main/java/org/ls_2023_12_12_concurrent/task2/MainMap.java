package org.ls_2023_12_12_concurrent.task2;

// Реализуйте программу, использующую ConcurrentMap, чтобы хранить и обновлять
// информацию о балансе нескольких пользовательских счетов в многопоточной среде.
// Разработайте метод для атомарного увеличения баланса на счету.

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MainMap {
    public static void main(String[] args) {
        Bank bank1 = new Bank();
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> bank1.deposit("1233-3456", 100));
            threads[i].start();
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(bank1.getBalance("1233-3456"));
    }
}
