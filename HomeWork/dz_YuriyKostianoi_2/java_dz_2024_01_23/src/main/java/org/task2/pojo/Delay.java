package org.task2.pojo;

public class Delay {
    private Delay() {
    }

    public static void delayProgressBar(int tact) {
        final int total = 100;
        for (int i = 0; i <= total; i++, sleep(tact))
            System.out.printf("\r[%s] %d%%", "=".repeat(i / 2), i);
        System.out.println();
    }

    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
