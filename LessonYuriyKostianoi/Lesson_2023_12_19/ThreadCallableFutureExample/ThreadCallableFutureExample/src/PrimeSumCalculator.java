import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class PrimeSumCalculator implements Callable<Long> {
    private final int start;
    private final int end;

    public PrimeSumCalculator(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Long call() {
        long sum = 0;
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        return sum;
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int start1 = 1;
        int end1 = 50;

        int start2 = 51;
        int end2 = 100;

        PrimeSumCalculator calculator1 = new PrimeSumCalculator(start1, end1);
        PrimeSumCalculator calculator2 = new PrimeSumCalculator(start2, end2);

        FutureTask<Long> task1 = new FutureTask<>(calculator1);
        FutureTask<Long> task2 = new FutureTask<>(calculator2);

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        try {
            long result1 = task1.get();
            long result2 = task2.get();

            System.out.println("Sum of prime numbers in range " + start1 + " to " + end1 + ": " + result1);
            System.out.println("Sum of prime numbers in range " + start2 + " to " + end2 + ": " + result2);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
