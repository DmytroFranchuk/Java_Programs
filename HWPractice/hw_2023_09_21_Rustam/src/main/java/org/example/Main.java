package org.example;

import java.util.*;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;

// Напишите функции:
// 1 printer которая будет заниматься печатанием в консоль входного параметра и вызовите эту фнкцию на строке,
// интежере и дабле
// 2 Проведения отложенной сортировки, функция будет принимать List и компаратор для сравнения и вызывает
// Collection.sort (подумайте про ссылку на метод)
// 3 Будет сначала добавлять к входной строке Test, после будет обрезать строку с 0 по 3 символ, потом будет добавлять
// в конец.
// 4 Используя соответственный примитивный интерфейс Supplier получить рандом значения и вывести их в консоль.
// (например BooleanSupplier booleanSupplier = () -> random.nextBoolean();)
public class Main {
    public static void main(String[] args) {
        // Task 1
        String str = "Hello, world!";
        int num = 42;
        double dbl = 3.14;
        printer(str);
        printer(num);
        printer(dbl);

        // Task 2
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 2, 8, 3, 1));
        System.out.println("Before sorting: " + numbers);
        deferredSort(numbers, Comparator.naturalOrder());
        System.out.println("After sorting: " + numbers);

        // Task 3
        String inputString = "Example";
        String result = manipulateString(inputString);
        System.out.println("Result: " + result);

        // Task 4
        BooleanSupplier booleanSupplier = () -> new Random().nextBoolean();
        IntSupplier intSupplier = () -> new Random().nextInt(100);
        DoubleSupplier doubleSupplier = () -> new Random().nextDouble();
        System.out.println("Random boolean: " + booleanSupplier.getAsBoolean());
        System.out.println("Random integer: " + intSupplier.getAsInt());
        System.out.println("Random double: " + doubleSupplier.getAsDouble());
    }

    public static void printer(Object obj) {
        System.out.println(obj);
    }

    public static <T> void deferredSort(List<T> list, Comparator<? super T> comparator) {
        list.sort(comparator);
    }

    public static String manipulateString(String input) {
        String modifiedString = input + "Test";
        modifiedString = modifiedString.substring(0, 4);
        modifiedString += input;
        return modifiedString;
    }
}