package org.ls_2023_11_30_NPE_Optional;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        System.out.println(getStringRepresentation("Java Pro").orElse("Получили значение null"));
        System.out.println(getStringRepresentation(null).orElse("Получили значение null"));

        System.out.println(getStringOptionalStartsWithA("Ananas")
                .orElse("Получили значение null"));
//        System.out.println(getStringOptionalStartsWithA("Banane")
//                .orElseThrow(()-> new RuntimeException("Первая буква не А")));

        System.out.println(getMsgOrDefault(Optional.of("Hello")));
//        System.out.println(getMsgOrDefault(null);
        System.out.println(getSumm(Optional.of(2), Optional.of(12)));
        System.out.println(getSumm(Optional.ofNullable(null), Optional.of(12)));

        System.out.println(getLenghtStr(Optional.of("Java pro")));
        System.out.println(getLenghtStr(Optional.ofNullable(null)));

    }

    private static Optional<String> getStringRepresentation(Object obj) {
        return obj == null ? Optional.empty() : Optional.of(obj.toString());
    }
    // 2 Создайте метод, который возвращает Optional для строки.
    // Если строка начинается с буквы "A",
    //верните её значение, иначе верните Optional.empty().

    private static Optional<String> getStringOptionalStartsWithA(String str) {
        return str != null && str.startsWith("A") ? Optional.of(str) : Optional.empty();
    }

    // 3 Создайте метод, который принимает Optional и возвращает его значение, или строку "Default",
    // если значение отсутствует.
    private static String getMsgOrDefault(Optional<String> optional) {
        return optional.orElse("Default");
    }

    // 4 Создайте метод, который принимает два Optional и возвращает их сумму. Если хотя бы одно из
    //значений отсутствует, верните Optional.empty().

    private static Optional<Integer> getSumm(Optional<Integer> op1, Optional<Integer> op2) {
        return op1.isEmpty() || op2.isEmpty() ? Optional.empty() : Optional.of(op1.get() + op2.get());
    }

    // 5 Создайте метод, который принимает Optional для строки и возвращает Optional для длины
    // этой строки.
    // Если входная строка null, бросьте IllegalArgumentException.

    private static Optional<Integer> getLenghtStr(Optional<String> str) {
        return Optional.of(str.orElseThrow(() -> new IllegalArgumentException("Null str")).length());
    }
}
