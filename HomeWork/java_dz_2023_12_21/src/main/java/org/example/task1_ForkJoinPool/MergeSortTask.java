package org.example.task1_ForkJoinPool;

import java.util.concurrent.RecursiveTask;

public class MergeSortTask extends RecursiveTask<String[]> {
    private final String[] array;
    private final int low;
    private final int high;

    public MergeSortTask(String[] array, int low, int high) {
        this.array = array;
        this.low = low;
        this.high = high;
    }

    @Override
    protected String[] compute() {

        return null;
    }
}
