package org.pr_2023_12_08.formula;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// 2 Напишите программу, которая вычисляет функцию ∑_(k=0)^n▒〖(1/√k)〗 для каждого целого числа
// от 1 до n, n – входной параметр (большое число, например, 10 000).
// Результат выводится на экран. Поскольку n – большое, необходимо разбить вычисления на
// несколько частей и каждую часть вычислить в отдельном потоке параллельно.
// Для каждой части нужно создать объект Task, внутри которого запомнить данные для
// начала вычислений, а также сохранить результат после завершения вычислений.
// Каждый поток работает со своим объектом Task.
public class Summarizer {
    private static final int MAX_RANGE_SIZE = 1000;

    private Summarizer() {

    }

    public static double calculateSumFormula(int low, int high) {
        double sum = 0;
        for (int k = low; k <= high; k++) {
            sum += 1.0 / Math.sqrt(k);
        }
        return sum;
    }

    public static double calculateSumFormula(int high) {
        return calculateSumFormula(1, high);
    }

    public static double parallelSum(int high) {
        if (high < MAX_RANGE_SIZE) return calculateSumFormula(high);
        List<Task> tasks = getTasks(high);
        for (Task task : tasks) {
            Thread thread = new Thread(() -> {
                task.setResult(calculateSumFormula(task.getLow(), task.getHigh()));
            });
            thread.start();
//            System.out.printf("Поток %d запущен для %s%n", thread.getId(), task);
        }
        double sum = 0;
        while (!tasks.isEmpty()) {
            for (Iterator<Task> i = tasks.iterator(); i.hasNext(); ) {
                Task task = i.next();
                if (task.getResult().isPresent()) {
                    sum += task.getResult().get();
                    i.remove();
//                    System.out.printf("Задача выполнена и удалена из списка задач результат = %s%n", task);
                }
            }
        }
        return sum;
    }

    private static List<Task> getTasks(int high) {
        List<Task> result = new ArrayList<>();
        for (int i = 1; i <= high; i += MAX_RANGE_SIZE) {
            result.add(new Task(i, Math.min(i + MAX_RANGE_SIZE - 1, high)));
        }
        return result;
    }
}
 