package org.example.task2;
// Напишите программу, которая вычисляет какую-либо сложную функцию для каждого
// целого числа от 1 до N, N – входной параметр (большое число, например, 10 000 000)
// N – ввод с консоли. Результат выводится на экран. Поскольку N – большое, необходимо
// разбить вычисления на несколько частей и каждую часть вычислить в отдельном
// потоке параллельно. Для каждой части нужно создать объект Task,
// внутри которого запомнить данные для начала вычислений, а так же сохранить результат
// после завершения вычислений. Каждый поток работает со своим объектом Task.

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TaskService taskService = new TaskService(32);
        Task[] tasks = new Task[taskService.getRanges().size()];
        System.out.println(taskService.getRanges());

        for (int i = 0; i < taskService.getRanges().size(); i++) {
            tasks[i] = new Task(taskService.getRanges().get(i));
        }
        for (Task task : tasks) {
            task.join();
        }
        long result = 0;
        for (Task task : tasks) {
            result += task.getSum();

        }
        System.out.println(result);
    }
}
