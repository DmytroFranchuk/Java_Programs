package org.ls_2023_11_28_lambda;

import java.util.function.*;

public class LambdaInterfaceNew {
    // s -> System.out.println(s);
    //x -> x*x;
    //s -> s == null || s.isBlank();
    //(age, name) -> System.out.printf("%s is %d years old", name, age);
    //(a, b) -> a + b;
    //(s1, s2) -> s1 != null && s2 != null && s1.length() > s2.length();
    public static void main(String[] args) {
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("Dima Franchuk");

        UnaryOperator<Integer> unaryOperator = x -> x * x;
        System.out.println(unaryOperator.apply(25));

        Predicate<String> predicate = s -> s == null || s.isBlank();
        System.out.println(predicate.test(" "));

        BiConsumer<Integer, String> biConsumer = (age, name) -> System.out.printf("%s is %d years old", name, age);
        biConsumer.accept(25, "Dima Franhuk");

        BinaryOperator<Integer> binaryOperator = (a, b) -> a + b;
        BinaryOperator<String> binaryOperator2 = (a, b) -> a + b;
        System.out.println(binaryOperator.apply(20, 25));
        System.out.println(binaryOperator2.apply("Dima", " Franchuk"));

        BiPredicate<String, String> biPredicate = (s1, s2) -> s1 != null && s2 != null && s1.length() > s2.length();
        System.out.println(biPredicate.test("Dima", "Dima"));
        System.out.println(biPredicate.test(null, "Dima"));
    }
}
