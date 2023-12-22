package org.pr_2023_12_22_Synchronizers.task_3_ForkJoinPool.search;

import java.io.File;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * Представим, что у нас есть крупная файловая система с множеством вложенных папок и файлов.
 * Задача - реализовать программу, использующую ForkJoinPool, для параллельного поиска файла с заданным
 * именем в этой файловой системе. Каждый поток будет отвечать за поиск в своей части файловой структуры.
 */
public class Main {

    public static void main(String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        String fileFind = "Spring_5.pdf";
        File directory = new File("C:\\");
        FileSearchTask task = new FileSearchTask(fileFind, directory);
        System.out.println(pool.invoke(task));
        pool.close();
    }
}
