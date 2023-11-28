package org.ls_2023_11_28_lambda;

import java.util.concurrent.Callable;

public class CallableNew {
    public static void main(String[] args) {
        Callable<Integer> sum = () -> getSum(8, 8);
        Callable<Integer> mul = () -> getMul(8, 2);
        Callable<Integer> dif = () -> getDiff(8, 4);
        Callable<Integer> div = () -> getDivide(10, 2);
        System.out.println(calculate(sum));
        System.out.println(calculate(mul));
        System.out.println(calculate(dif));
        System.out.println(calculate(div));
    }

    public static int getSum(int a, int b) {
        return a + b;
    }

    public static int getDiff(int a, int b) {
        return a - b;
    }

    public static int getDivide(int a, int b) {
        return a / b;
    }

    public static int getMul(int a, int b) {
        return a * b;
    }

    public static int calculate(Callable<Integer> operation) {
        System.out.println("Выполняю вычисление");
        int i = 0;
        try {
            i = operation.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Вычисленное значение");
        return i;
    }
}
