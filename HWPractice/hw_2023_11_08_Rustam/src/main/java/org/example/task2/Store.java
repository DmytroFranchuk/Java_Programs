package org.example.task2;

import java.util.concurrent.atomic.AtomicInteger;

public class Store {
    private static final int TOTAL_COUNT_PRODUCTS = 1000;
    private static AtomicInteger availableCount = new AtomicInteger(TOTAL_COUNT_PRODUCTS);

    public static int getAvailableCount() {
        return availableCount.get();
    }

    public static void buyProducts(int count, int idCustomer){
        if (availableCount.get() >= count){
            availableCount.addAndGet(-count);
            System.out.println("Покупатель " + idCustomer + ": купил " + count +
                    " продуктов. Осталось только " + availableCount.get() + " продуктов ");
        } else if (availableCount.get() > 0){
            System.out.println("Покупатель " + idCustomer + ": может купить только " +
                    availableCount.get() + " продуктов");
            availableCount.addAndGet(-availableCount.get());
        } else System.out.println("Покупатель " + idCustomer + ": не может купить продукты. " +
                    "Продукты закончились ");
    }
}
