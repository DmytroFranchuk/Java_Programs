package org.ls_2023_12_07_Thread2.model.producerConsumer.model;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    private final Queue<Integer> tasks = new LinkedList<>();
    private static final int MAX_SIZE = 5;

    public synchronized void produce(int task) throws InterruptedException {
        System.out.println("В очереди: " + tasks.size() + " заданий сказал produce-производитель");
        while (tasks.size() == MAX_SIZE) {
            // Ждем, пока потребитель заберет задание из очереди
            wait();
        }
        tasks.add(task);
        System.out.println("Produced добавил в очередь: задание №" + task);
        // Сигнализируем потребителям, что в очереди есть новое задание
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        System.out.println("В очереди: " + tasks.size() + " заданий сказал consume-потребитель");
        while (tasks.isEmpty()) {
            // Ждем, пока производитель добавит задание в очередь
            wait();
        }
        int task = tasks.poll();
        System.out.println("Consumed забрал с очереди: задание №" + task);
        // Сигнализируем производителям, что в очереди есть свободное место
        notify();
    }
}

