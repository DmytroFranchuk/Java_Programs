package org.example.dz_2023_11_07;

import java.util.Date;

public class ThreadExample {
    public static void main(String[] args) {
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println(new Date());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("Thread state before starting: " + daemonThread.getState());

        daemonThread.setDaemon(true);
        daemonThread.start();

        try {
            Thread.sleep(60000); // 1 minute
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread state while running: " + daemonThread.getState());
    }
}
