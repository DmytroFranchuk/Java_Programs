package org.example.task3_OrderDeliveryManagement;

import java.util.concurrent.PriorityBlockingQueue;

public class DeliveryTask implements Runnable {
    private PriorityBlockingQueue<Order> priorityBlockingQueue;

    public DeliveryTask(PriorityBlockingQueue<Order> priorityBlockingQueue) {
        this.priorityBlockingQueue = priorityBlockingQueue;
    }

    @Override
    public void run() {
        if (!priorityBlockingQueue.isEmpty()) {
            Order order = priorityBlockingQueue.poll();
            System.out.printf("Доставка товара %s происходит потоком %s%n", order.getOrderId(), Thread.currentThread().getId());
            try {
                Thread.sleep(order.getDeliveryTime() * 100L);
                System.out.printf("Товар %s доставлен потоком %s по адресу %s за время %s%n", order.getOrderId(), Thread.currentThread().getId(),
                        order.getDeliveryAddress(), order.getDeliveryTime());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
