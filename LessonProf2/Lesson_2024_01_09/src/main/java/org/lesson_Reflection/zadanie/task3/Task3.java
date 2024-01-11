package org.lesson_Reflection.zadanie.task3;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// Создайте метод, который принимает переменную типа List. Выведите описание всех
// методов переданного списка. В main вызовите метод, передав в него
// • экземпляр ArrayList
// • экземпляр LinkedList
// • экземпляр, полученный методом List.of()
public class Task3 {
    public static void main(String[] args) {
        printMethodList(new ArrayList<>());
        System.out.println("==============================================");
        printMethodList(new LinkedList<>());
        System.out.println("==============================================");
        printMethodList(List.of());
    }

    private static void printMethodList(List<String> stringList) {
        Class<? extends List> clazz = stringList.getClass();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            String name = method.getName();
            String returnType = method.getReturnType().getSimpleName();
            List<String> inputTypes = Arrays.stream(method.getParameterTypes())
                    .map(Class::getSimpleName)
                    .toList();
            List<String> exeptionTypes = Arrays.stream(method.getExceptionTypes())
                    .map(Class::getSimpleName)
                    .toList();
            System.out.printf("Method %s, Return %s, Params %s, Exeptions %s%n", name, returnType, inputTypes, exeptionTypes);

        }
    }
}
