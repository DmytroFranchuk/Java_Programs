package org.ls_2023_12_21_Synchronizers.task1_ForkJoin.sales;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;

// Представьте, что у вас есть сеть магазинов, и вы хотите рассчитать общую выручку за определенный период времени.
// Каждый магазин предоставляет данные о продажах в виде массива. Вам нужно эффективно подсчитать общую сумму продаж
// для всех магазинов с использованием параллельных вычислений.
// Шаги:
// Создайте класс, расширяющий RecursiveTask<Long>, представляющий задачу подсчета выручки для определенного магазина.
// В конструкторе класса укажите массив продаж и границы массива для текущего магазина. В методе compute() вычислите
// общую сумму продаж для текущего магазина. Если количество продаж невелико, вычислите сумму напрямую. Если количество
// продаж больше порогового значения, разделите задачу на две подзадачи для параллельного выполнения.
// Дождитесь завершения подзадач и объедините их результаты для получения общей выручки.
public class Main {
    public static void main(String[] args) {
        List<int[]> sails = Arrays.stream(new Object[3])
                .map(e -> ThreadLocalRandom.current().ints(500).map(Math::abs).toArray()).toList();
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        int[] massiv = sails.stream().flatMapToInt(m -> Arrays.stream(m)).toArray();
        SalesTask task = new SalesTask(0,massiv.length-1, massiv);
        Long result = forkJoinPool.invoke(task);
        System.out.println(Arrays.toString(massiv));
        System.out.println(result);
    }
}
