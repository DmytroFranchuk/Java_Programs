package org.ls_2023_12_05_Thread.task2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread;
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            thread = new Thread(() ->
            {
                for (int j = 0; j < 100; j++) {
                    System.out.print(finalI + ", ");
                }
            }, String.valueOf(i));
            thread.setPriority(finalI+1);
            thread.start();
//            Thread.sleep(1000);
        }
    }
}
