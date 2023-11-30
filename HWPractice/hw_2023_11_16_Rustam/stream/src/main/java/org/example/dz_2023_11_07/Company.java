package org.example.dz_2023_11_07;

public class Company {
    private int balance = 0;

    public static void main(String[] args) {
        Company company = new Company();

        Thread expensesThread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (company) {
                    company.balance -= 5;
                }
            }
        });

        Thread incomeThread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (company) {
                    company.balance += 10;
                }
            }
        });

        expensesThread.start();
        incomeThread.start();

        try {
            expensesThread.join();
            incomeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance: " + company.balance);
    }
}
