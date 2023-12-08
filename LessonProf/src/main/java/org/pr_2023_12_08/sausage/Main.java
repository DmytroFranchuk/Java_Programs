package org.pr_2023_12_08.sausage;

public class Main {
    public static void main(String[] args) {

        Sausage sausage = new Sausage(7);
        Runnable eating = () -> {
            String nameThread = Thread.currentThread().getName();
            while (sausage.bite() > 0) {
                System.out.println(nameThread + "Я жую сосиску ням ням ням");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Я закончил кушать пошел играть: " + nameThread);
        };
        Thread kittenGav = new Thread(eating, "kittenGav");
        Thread puppySharik = new Thread(eating, "puppySharik");
        kittenGav.start();
        puppySharik.start();
    }
}
