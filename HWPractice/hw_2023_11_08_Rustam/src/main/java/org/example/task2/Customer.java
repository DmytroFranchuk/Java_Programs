package org.example.task2;

import java.util.concurrent.ThreadLocalRandom;

public class Customer implements Runnable{
    private int id;

    public Customer(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        int countToBuy = ThreadLocalRandom.current().nextInt(1, 100);
        Store.buyProducts(countToBuy, id);
    }
}
