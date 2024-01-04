package org.example.task3_OrderDeliveryManagement;

// В интернет-магазине есть два процесса: обработка заказов и доставка товаров.
// На фоне обработки заказов, нужно периодически планировать доставку готовых товаров.
// Разработайте программу, используя ThreadPoolExecutor и ScheduledThreadPoolExecutor,
// чтобы эффективно управлять обработкой заказов и доставкой.

import java.util.Comparator;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        int corePoolSize = 2;
        int maxPoolSize = 5;
        long keepAliveTime = 1;
        BlockingQueue<Runnable> ordersQueue = new LinkedBlockingQueue<>(150);
        PriorityBlockingQueue<Order> deliveryQueue = new PriorityBlockingQueue<>(150,
                Comparator.comparingInt(Order::getDeliveryTime).reversed());

        ThreadPoolExecutor es = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, TimeUnit.MILLISECONDS, ordersQueue);
        ScheduledExecutorService deliveryScheduler = Executors.newScheduledThreadPool(4);
        deliveryScheduler.scheduleAtFixedRate(new DeliveryTask(deliveryQueue), 0, 1, TimeUnit.SECONDS);

        for (int i = 0; i < 10; i++) {
            es.execute(new OrderTask(deliveryQueue));
        }

        es.shutdown();
        try {
            es.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        while (!deliveryQueue.isEmpty()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        deliveryScheduler.shutdown();
        try {
            deliveryScheduler.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Все задачи по обработке заказов и доставке завершены.");
    }
}