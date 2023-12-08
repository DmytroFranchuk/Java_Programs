package org.pr_2023_12_08.formula;

public class Main {
    public static void main(String[] args) {
        System.out.println(Summarizer.parallelSum(100));
        System.out.println(Summarizer.calculateSumFormula(100));
        System.out.println("Вызываем для большого числа");
        System.out.println(Summarizer.parallelSum(10_000));
        System.out.println(Summarizer.calculateSumFormula(10_000));
        System.out.println("Время выполнения");
        System.out.println("Parallel: " + getMils(() -> Summarizer.parallelSum(1_000_000)));
        System.out.println("" + getMils(() -> Summarizer.calculateSumFormula(1_000_000)));
    }

    private static long getMils(Runnable runnable) {
        long start = System.currentTimeMillis();
        runnable.run();
        return System.currentTimeMillis() - start;
    }
}
