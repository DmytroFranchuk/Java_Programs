package org.ls_2023_12_21_Synchronizers.task1_ForkJoin.sales;

import java.util.concurrent.RecursiveTask;

public class SalesTask extends RecursiveTask<Long> {
    private static final int THRESHOLD = 500;
    private int start;
    private int end;
    private int[] sales;

    public SalesTask(int start, int end, int[] sales) {
        this.start = start;
        this.end = end;
        this.sales = sales;
    }

    @Override
    protected Long compute() {
        if ((end-start) < THRESHOLD) {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += sales[i];
            }
            return sum;
        } else {
            int mid = (start + end) / 2;
            SalesTask left = new SalesTask(start, mid, sales);
            SalesTask right = new SalesTask(mid+1, end, sales);
            left.fork();
            long rightresult = right.compute();
            long leftresult = left.join();
            return leftresult + rightresult;
        }
    }
}
