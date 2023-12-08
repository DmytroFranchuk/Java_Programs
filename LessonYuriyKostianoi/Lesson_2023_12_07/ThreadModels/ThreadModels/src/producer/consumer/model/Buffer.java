package producer.consumer.model;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    private final Queue<Integer> tasks = new LinkedList<>();
    private static final int MAX_SIZE = 5;

    public synchronized void produce(int task) throws InterruptedException {
        while (tasks.size() == MAX_SIZE) {
            // Ждем, пока потребитель заберет задание из очереди
            wait();
        }
        tasks.add(task);
        System.out.println("Produced: " + task);
        // Сигнализируем потребителям, что в очереди есть новое задание
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while (tasks.isEmpty()) {
            // Ждем, пока производитель добавит задание в очередь
            wait();
        }
        int task = tasks.poll();
        System.out.println("Consumed: " + task);
        // Сигнализируем производителям, что в очереди есть свободное место
        notify();
    }
}
