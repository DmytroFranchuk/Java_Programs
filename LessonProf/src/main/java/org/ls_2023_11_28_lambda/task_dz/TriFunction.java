package org.ls_2023_11_28_lambda.task_dz;
//Создайте собственный функциональный интерфейс, внутри которого определите метод
//execute, принимающий три аргумента типа T и возвращающий результат типа R.

@FunctionalInterface
public interface TriFunction<T, R> {
    R execute(T t1, T t2, T t3);
}
