package org.example.task1;

import org.springframework.scheduling.annotation.Scheduled;
import javax.crypto.IllegalBlockSizeException;
import java.time.LocalDate;
import java.util.*;

public class MyClass {
    private int number;
    private String text;
    private boolean flag;
    private double value;

    public void methodNum$01() throws IllegalAccessException, InterruptedException {
        System.out.println("Вызван метод 1");
    }
    @Scheduled(cron = "0 0 12 * * ?")
    public void methodNum$02(String s) {
        System.out.println("Вызван метод 2: " + text + " " + s);
    }

    public void methodNum$03(String s1, String s2) throws ReflectiveOperationException {
        System.out.println("Вызван метод 3: " + s1 + " - " + s2);
    }
    @Deprecated
    public static final List<MyClass2> methodNum$04(boolean type) {
        List<MyClass2> resultList = new ArrayList<>();
        resultList.add(new MyClass2(10L));
        resultList.add(new MyClass2(20L));
        resultList.add(new MyClass2(30L));
        System.out.println("Вызван метод 4: " + type);
        return resultList;
    }

    public int[] methodNum$05(boolean isPrint, int value)  {
        System.out.println("Вызван метод 5: " + value);
        if (!isPrint) return new int[5];
        return new int[value];
    }

    private void methodNum$06(String s) {
        System.out.println("Вызван метод 6: " + s);
    }
    private String methodNum$07(double value) {
        String str = String.valueOf(value);
        System.out.println("Вызван метод 7: " + str);
        return str;
    }

    private static final Map<LocalDate, Integer> methodNum$08(Integer count, boolean isDate) {
        Map<LocalDate, Integer> map = new HashMap<>();
        System.out.println("Вызван метод 8" + count);
        if (isDate) {
            map.put(LocalDate.now(), count);
        }
        return map;
    };

    protected void methodNum$09(String str1, String str2) throws IllegalFormatException, IllegalBlockSizeException {
        System.out.println("Вызван метод 9: " + str1 + str2);
    }

    protected void methodNum$10(int count, String str) throws IllegalCallerException, IllegalFormatCodePointException {
        System.out.println("Вызван метод 10: " + str + " - " + count);
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "number=" + number +
                ", text='" + text + '\'' +
                ", flag=" + flag +
                ", value=" + value +
                '}';
    }
}
