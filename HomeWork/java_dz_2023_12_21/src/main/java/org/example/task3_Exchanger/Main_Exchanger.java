package org.example.task3_Exchanger;

import java.util.concurrent.Exchanger;

public class Main_Exchanger {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        Thread producer = new Thread(() -> {
            try {
                String data = "Новые данные от генератора";
                System.out.println("Генератор генерирует данные: " + data);
                exchanger.exchange(data);
                System.out.println("Генератор завершил работу");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread consumer = new Thread(() -> {
            try {
                String receivedData = exchanger.exchange(null);
                System.out.println("Обработчик получил данные: " + receivedData);
                System.out.println("Обработчик завершил работу");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Программа завершила работу");
    }
}
