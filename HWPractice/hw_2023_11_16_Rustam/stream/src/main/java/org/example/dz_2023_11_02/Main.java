package org.example.dz_2023_11_02;

public class Main extends Thread {
    @Override
    public void run() {
        System.out.println("Hello World!");
    }

    public static void main(String[] args) {
        Main thread = new Main();
        thread.start();
    }
}
