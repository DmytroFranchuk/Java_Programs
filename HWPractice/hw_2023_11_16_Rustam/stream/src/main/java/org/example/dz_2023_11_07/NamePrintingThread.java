package org.example.dz_2023_11_07;

public class NamePrintingThread extends Thread {
    private String threadName;

    public NamePrintingThread(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        System.out.println("Поток: " + threadName);
    }
}
