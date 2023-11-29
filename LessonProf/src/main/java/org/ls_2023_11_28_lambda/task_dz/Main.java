package org.ls_2023_11_28_lambda.task_dz;

public class Main {
    public static void main(String[] args) {


    }
    // В Main создайте метод, checkAndGet, принимающий экземпляр данного интерфейса и три
    // строки. Если хотя бы одна из переданных строк null, метод возвращает null. В противном
    // случае вызывает метод execute.

    public static <T, R> R checkAndGet(TriFunction<T, R> function, T t1, T t2, T t3) {
        if (t1 == null || t2 == null || t3 == null) return null;
        else return function.execute(t1, t2, t3);
    }
}
