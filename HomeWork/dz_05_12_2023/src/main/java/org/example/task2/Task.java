package org.example.task2;

public class Task extends Thread {
    private Range range;
    private long sum;

    public Task(Range range) {
        this.range = range;
        this.start();
    }

    public long getSum() {
        return sum;
    }

    @Override
    public void run() {
        sum = complexFunction(range);
    }

    private static long complexFunction(Range range) {
        long sum = 0;
        for (long i = range.getStart(); i <= range.getEnd(); i++) {
            if (i != 0) sum += ((i / i) * (i / i) * (i / i));
            else sum += 1;
        }
        return sum;
    }

    @Override
    public String toString() {
        return String.format(this.getName() + " Task sum = " + sum);
    }
}
