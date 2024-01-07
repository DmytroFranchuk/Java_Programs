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
        if (low == high) {
            return new String[]{array[low]};
        }
        if (low + 1 == high) {
            if (array[low].compareTo(array[high]) > 0) {
                String temp = array[low];
                array[low] = array[high];
                array[high] = temp;
            }
            return new String[]{array[low], array[high]};
        }
        int mid = low + (high - low) / 2;
        MergeSortTask leftTask = new MergeSortTask(array, low, mid);
        MergeSortTask rightTask = new MergeSortTask(array, mid + 1, high);
        leftTask.fork();
        rightTask.fork();
        String[] leftResult = leftTask.join();
        String[] rightResult = rightTask.join();
        return merge(leftResult, rightResult);
    }

    private String[] merge(String[] left, String[] right) {
        int leftLength = left.length;
        int rightLength = right.length;
        int mergedLength = leftLength + rightLength;
        String[] mergedArray = new String[mergedLength];
        int leftPointer = 0, rightPointer = 0, mergedPointer = 0;
        while (leftPointer < leftLength && rightPointer < rightLength) {
            if (left[leftPointer].compareTo(right[rightPointer]) <= 0) {
                mergedArray[mergedPointer++] = left[leftPointer++];
            } else {
                mergedArray[mergedPointer++] = right[rightPointer++];
            }
        }
        while (leftPointer < leftLength) {
            mergedArray[mergedPointer++] = left[leftPointer++];
        }
        while (rightPointer < rightLength) {
            mergedArray[mergedPointer++] = right[rightPointer++];
        }
        return mergedArray;
    }
}
