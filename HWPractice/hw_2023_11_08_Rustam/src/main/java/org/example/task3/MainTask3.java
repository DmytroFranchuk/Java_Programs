package org.example.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MainTask3 {
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Помыть посуду", ThreadLocalRandom.current().nextInt(10, 10_000)));
        tasks.add(new Task("Почистить зубы", ThreadLocalRandom.current().nextInt(10, 10_000)));
        tasks.add(new Task("Поесть", ThreadLocalRandom.current().nextInt(10, 10_000)));
        tasks.add(new Task("Сходить в магазин", ThreadLocalRandom.current().nextInt(10, 10_000)));
        tasks.add(new Task("Купить подарок маме на день рождения", ThreadLocalRandom.current().nextInt(10, 10_000)));
        tasks.add(new Task("Приготовить ужин", ThreadLocalRandom.current().nextInt(10, 10_000)));
        tasks.add(new Task("Убрать в комнате", ThreadLocalRandom.current().nextInt(10, 10_000)));
        tasks.add(new Task("Застелить кровать", ThreadLocalRandom.current().nextInt(10, 10_000)));
        tasks.add(new Task("Вынести мусор", ThreadLocalRandom.current().nextInt(10, 10_000)));
        tasks.add(new Task("Почистить обувь", ThreadLocalRandom.current().nextInt(10, 10_000)));

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            List<Future<String>> results = executorService.invokeAll(tasks);
            for (Future<String> f: results) {
                try {
                    System.out.println(f.get());
                    Thread.sleep(50);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
