package org.example.pole.chudes;

import java.util.HashSet;
import java.util.Set;

public class Bascket {
    private final Set<Candy> bascket;
    private static final int MAX_SIZE = 10;


    public Bascket() {
        this.bascket = new HashSet<>();
    }
    public synchronized Candy getCandy() throws InterruptedException {
        while(bascket.isEmpty()){
            System.out.println("Корзинка: ждем появления конфет ");
            wait();
        }
        Candy candy = bascket.stream().findFirst().orElseThrow();
        bascket.remove(candy);
        System.out.println("Корзинка: взяли конфету " +candy.getId());
        notify();
        return candy;
    }

    public synchronized void putCandy(Candy candy) throws InterruptedException {
        while(bascket.size()==MAX_SIZE){
            wait();
        }
        bascket.add(candy);
        System.out.println("Корзинка: положили конфету " +candy.getId());
        notify();
    }
}
