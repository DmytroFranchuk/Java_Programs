package org.example.task1_ForkJoinPool;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class MergeSortTask extends RecursiveTask<String[]> {
    private final String[] array;

    public MergeSortTask(String[] array) {
        this.array = array;
    }

    @Override
    protected String[] compute() {
        if (array.length <= 1) {
            return array;
        }

        int mid = array.length / 2;
        String[] leftArray = Arrays.copyOfRange(array, 0, mid);
        String[] rightArray = Arrays.copyOfRange(array, mid, array.length);

        MergeSortTask leftTask = new MergeSortTask(leftArray);
        MergeSortTask rightTask = new MergeSortTask(rightArray);

        leftTask.fork();
        rightTask.fork();

        String[] leftResult = leftTask.join();
        String[] rightResult = rightTask.join();

        return merge(leftResult, rightResult);
    }

    private String[] merge(String[] left, String[] right) {
        String[] mergedArray = new String[left.length + right.length];
        int leftPointer = 0, rightPointer = 0, mergedPointer = 0;

        while (leftPointer < left.length && rightPointer < right.length) {
            if (left[leftPointer].length() <= right[rightPointer].length()) {
                mergedArray[mergedPointer++] = left[leftPointer++];
            } else {
                mergedArray[mergedPointer++] = right[rightPointer++];
            }
        }

        while (leftPointer < left.length) {
            mergedArray[mergedPointer++] = left[leftPointer++];
        }

        while (rightPointer < right.length) {
            mergedArray[mergedPointer++] = right[rightPointer++];
        }

        return mergedArray;
    }
}
