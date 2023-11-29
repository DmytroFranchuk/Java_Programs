package org.example.dz_2023_11_07;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        NamePrintingThread thread1 = new NamePrintingThread("поток-1");
        NamePrintingThread thread2 = new NamePrintingThread("поток-2");
        NamePrintingThread thread3 = new NamePrintingThread("поток-3");

        thread1.start();
        thread2.start();
        thread3.start();

        MinMaxThreads.minMaxStart();
    }
}
