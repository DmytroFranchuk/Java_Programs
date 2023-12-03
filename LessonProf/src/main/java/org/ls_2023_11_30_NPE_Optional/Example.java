package org.ls_2023_11_30_NPE_Optional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class Example {
    public static void main(String[] args) {

        //1 Создайте метод, который принимает Optional для строки и возвращает Optional для длины этой строки.
        System.out.println(getLenghtStr(Optional.ofNullable("ABC")));
        System.out.println(getLenghtStr(Optional.ofNullable(null)));
        System.out.println(getLenghtStr(Optional.ofNullable("")));
        System.out.println(isPresentAndPositive(Optional.of(-8)));
        System.out.println(isPresentAndPositive(Optional.of(50)));
        System.out.println(isPresentAndPositive(Optional.ofNullable(null)));
        List<String> newList1 = new ArrayList<>();
        newList1.add("A");
        newList1.add("B");
        newList1.add("C");
        newList1.add(null);
        List<String> newList2 = new ArrayList<>();
        newList2.add("D");
        newList2.add("E");
        newList2.add("F");
        newList2.add(null);

        System.out.println(join(newList1, newList2));
        System.out.println(join(newList2, newList1));

    }

    private static Optional<Integer> getLenghtStr(Optional<String> str) {
        return (str == null) ? Optional.empty() : str.map(s -> s.length());
    }

    // 2 Создайте метод, который принимает Optional и возвращает true, если значение присутствует и
    // является положительным числом, иначе false.

    private static boolean isPresentAndPositive(Optional<Integer> num) {
        return num.filter(x -> x > 0).isPresent();
    }

    // Создайте метод, который принимает два списка строк и возвращает их объединение. Сначала метод берёт
    // очередное значение из первой очереди. Если оно null, то берёт значение из второго списка.
    // Если значение второго списка null, то берётся значение по умолчанию.

    private static List<String> join(List<String> list1, List<String> list2) {
        List<String> joinList = new ArrayList<>();

        Iterator<String> i1 = list1.iterator();
        Iterator<String> i2 = list2.iterator();

        while (i1.hasNext() || i2.hasNext()) {
            String el1 = i1.hasNext() ? i1.next() : null;
            joinList.add(Optional.ofNullable(el1)
                    .or(() -> i2.hasNext() ? Optional.ofNullable(i2.next()) : Optional.empty())
                    .orElse("QyQy"));
        }
        return joinList;
    }


}
