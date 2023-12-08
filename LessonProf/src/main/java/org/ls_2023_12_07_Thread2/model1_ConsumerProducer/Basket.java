package org.ls_2023_12_07_Thread2.model1_ConsumerProducer;

import java.util.HashSet;
import java.util.Set;

public class Basket {
    private final Set<Candy> basket;
    private static final int MAX_SIZE = 10;


    public Basket() {
        this.basket = new HashSet<>();
    }

    public synchronized Candy getCandy() throws InterruptedException {
        while (basket.isEmpty()) {
            System.out.println("Корзинка: ждем появления конфет ");
            wait();
        }
        Candy candy = basket.stream().findFirst().orElseThrow();
        basket.remove(candy);
        System.out.println("Корзинка: взяли конфету " + candy.getId());
        notify();
        return candy;
    }

    public synchronized void putCandy(Candy candy) throws InterruptedException {
        while (basket.size() == MAX_SIZE) {
            wait();
        }
        basket.add(candy);
        System.out.println("Корзинка: положили конфету " + candy.getId());
        notify();
    }

}
