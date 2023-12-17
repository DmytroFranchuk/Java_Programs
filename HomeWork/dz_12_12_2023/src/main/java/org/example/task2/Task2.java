package org.example.task2;

// 2 Дан список чисел из большого количества случайных чисел. Используя
// синхронизированные коллекции, уберите из списка отрицательные значения. Замерьте
// время выполнения метода в однопоточном режиме и в многопоточном.

import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        Generator generator = new Generator();
        List<Integer> result = generator.generatorList(20, -100, 100);
        System.out.println(result);

        long start = System.currentTimeMillis();
        List<Integer> positiveValues = Utils.removeNegativeValuesParallel(result);
        System.out.println("Время выполнения в многопоточном режиме: " + (System.currentTimeMillis() - start) + " мсек");
        System.out.println(positiveValues);

        start = System.currentTimeMillis();
        positiveValues = Utils.removeNegativeValues(result);
        System.out.println("Время выполнения в однопоточном режиме: " + (System.currentTimeMillis() - start) + " мсек");
        System.out.println(positiveValues);
    }

}
