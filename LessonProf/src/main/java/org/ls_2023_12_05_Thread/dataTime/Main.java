package org.ls_2023_12_05_Thread.dataTime;

public class Main {
    public static void main(String[] args) {
        Today today = new Today();
        Thread threadToday = new Thread(()->today.getTodayDate());
        threadToday.start();

        Thread thread1 = new Thread(()->System.out.println(today.getMyDate().getYear()+5));
        thread1.start();
        Thread thread2 = new Thread(()->System.out.println(today.getMyDate().getYear()+3));
        thread2.start();
    }
}
