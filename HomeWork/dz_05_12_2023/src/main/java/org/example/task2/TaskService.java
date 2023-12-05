package org.example.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskService {
    private List<Range> ranges;

    public TaskService(int countTask) {
        this.ranges = splitRange(getValueFromConsole(), countTask);
    }

    public List<Range> getRanges() {
        return ranges;
    }

    private static List<Range> splitRange(long value, int count) {
        List<Range> ranges = new ArrayList<>();
        long quotient = value / count;
        long remainder = value % count;
        long start = 0;
        long end;
        for (int i = 0; i < count; i++) {
            end = start + quotient + (i < remainder ? 1 : 0) - 1;
            ranges.add(new Range(start, end));
            start = end + 1;
        }
        return ranges;
    }

    private static long getValueFromConsole() {
        Scanner scanner = new Scanner(System.in);
        boolean isValid = false;
        long result = 0;
        while (!isValid) {
            System.out.print("Введите число типа long: ");
            if (scanner.hasNextLong()) {
                result = scanner.nextLong();
                if (result >= 10_000_000 && result <= Long.MAX_VALUE) {
                    isValid = true;
                }
            } else scanner.next();
        }
        scanner.close();
        return result;
    }
}
