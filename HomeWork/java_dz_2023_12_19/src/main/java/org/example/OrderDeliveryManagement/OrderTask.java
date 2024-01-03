package org.example.OrderDeliveryManagement;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

public class OrderTask implements Runnable {
    private Order order;
    private PriorityBlockingQueue<Order> priorityBlockingQueue;

    public OrderTask(PriorityBlockingQueue<Order> priorityBlockingQueue) {
        this.order = generateOrder();
        this.priorityBlockingQueue = priorityBlockingQueue;
    }

    public Order getOrder() {
        return order;
    }

    private Order generateOrder() {
        int orderCount = new Random().nextInt(5) + 1; // Случайное количество товаров в заказе от 1 до 5
        int deliveryTime = new Random().nextInt(10) + 1; // Случайное время доставки от 1 до 10 секунд
        return new Order(orderCount, deliveryTime);
    }

    @Override
    public void run() {
        System.out.printf("Обработка заказа %s происходит в потоке %s%n", order.getOrderId(), Thread.currentThread().getId());
        try {
            Thread.sleep(500L * order.getOrderCount());
            order.setProcessed(true);
            priorityBlockingQueue.put(order);
            System.out.printf("Обработка заказа %s закончена потоком %s%n", order.getOrderId(), Thread.currentThread().getId());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
