package org.ls_2023_12_12_concurrent.task1;

import java.util.ArrayList;
import java.util.List;

// Создайте 5 потоков, каждый из которых генерирует случайные числа.
// Создайте класс ParallelRandom и в нем метод генерации списка из
// заданного количества элементов.
// Заполните список из 10_000 элементов с помощью ParallelRandom.

// Дополните ParallelRandom методом генерации множества случайных чисел.
// Ради эксперимента попробуйте у сформированного CopyOnWriteArraySet вызвать
// операцию удаления элемента.

public class Main {
    public static void main(String[] args) {
        ParallelRandom parallelRandom = new ParallelRandom();
        int countOfBounds = 10;
        List<Integer> list1 = parallelRandom.generateNums(countOfBounds);
//        System.out.println(list1);

//        long start = System.currentTimeMillis();
//        ParallelRandom.fillIn(new ArrayList<>(), countOfBounds);
//        System.out.println(System.currentTimeMillis() - start);
//
//        start = System.currentTimeMillis();
//        parallelRandom.generateNums(countOfBounds);
//        System.out.println(System.currentTimeMillis() - start);
//        System.out.println("The End !");

        System.out.println(parallelRandom.generateUniqueNums(list1));
    }
}
