package org.example.task1_ForkJoinPool;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

// Дан массив строк на 10_000 элементов. Отсортируйте строки по длине, используя
// сортировку слиянием. Сортировка должна быть выполнена в многопоточном режиме с
// применением ForkJoinPool
public class MergeSortMain {
    public static void main(String[] args) {
        String[] strings = FakerStringArrayGenerator.generateRandomStrings(100, 15);
        System.out.println(Arrays.toString(strings));
        ForkJoinPool pool = new ForkJoinPool();
        MergeSortTask task = new MergeSortTask(strings);
        String[] sortedStrings = pool.invoke(task);
        System.out.println(Arrays.toString(sortedStrings));
    }
}