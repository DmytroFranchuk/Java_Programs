package org.example.task2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int countCustomers = 200;
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 1; i <= countCustomers; i++) {
            executorService.execute(new Customer(i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        executorService.shutdown();
    }
}
//Cоздайте программу, в которой используя ThreadExecutors будем решать следующую задачу: Представим что есть компания,
//у которой есть 1_000 товаров и есть 10 касс обслуживания - каждый поток это покупатель, в магазин пришло 200 покупателей,
//каждый покупатель может купить рандомно от 1 до 100 товаров, после совершения покупки количество товаров уменьшается,
//если количество товаров меньше 0, то писать в консоль, что товар закончился (каждый покупатель будет писать это в
//консоль) P.S. подумайте о том что количество товаров это единый счетчик между потоками, подумайте какой экзекьютор
//использовать