package org.ls_2023_12_05_Thread.chickenandegg;

import java.util.Random;

public class Chicken extends Thread {
    public Chicken() {
        super("Chicken");
    }

    @Override
    public void run() {
        try {
            Random random = new Random();
            long delay = 1000 + random.nextInt(2001);
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.getName());
    }
}
