package org.example.task1;
// Создайте класс с 10 методами и 4 приватными полями. Геттеры и сеттеры добавлять не
// нужно. Создайте объект Вашего класса.
// Выведите в консоль информацию об объекте.

// Затем пользователь вводит имя поля или метода. Программа определяет, имя какого члена
// класса было введено. Если введено имя метода, то этот метод немедленно вызывается.
// Если введено имя поля, то программа запрашивает у пользователя новое значение и
// устанавливает его новым значением этого поля.

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        MyClass myObject = new MyClass();
        infoObject(myObject);

        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        System.out.print("Пример запуска метода: methodNum$10, 25, test");
        while (run) {
            System.out.print("\nВведите имя поля или метода: ");
            String input = scanner.nextLine();
            if ("exit".equals(input)) {
                run = false;
            } else {
                runMethodObject(myObject, input);
            }
        }
    }

    public static void infoObject(Object objClass) {
        Class<?> testClass = objClass.getClass();
        Method[] methods = testClass.getDeclaredMethods();
        Arrays.sort(methods, Comparator.comparing(Method::getName));
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    public static void runMethodObject(Object objClass, String input) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> clazz = objClass.getClass();
        String[] params = parseParams(input);
        String methodName = params[0].trim();
        if (params.length > 1) {
            Method method = findMethod(clazz, methodName, params.length - 1);
            Object[] parameters = new Object[params.length - 1];
            for (int i = 1; i < params.length; i++) {
                parameters[i - 1] = parseParameterValue(params[i].trim());
            }
            method.setAccessible(true);
            method.invoke(objClass, parameters);
        } else {
            Method method = findMethod(clazz, methodName, params.length - 1);
            method.setAccessible(true);
            method.invoke(objClass);
        }
    }

    private static Object parseParameterValue(String parameter) {
        if (parameter.matches("-?\\d+")) {
            return Integer.parseInt(parameter);
        }
        if (parameter.matches("-?\\d+(\\.\\d+)?")) {
            return Double.parseDouble(parameter);
        }
        if (parameter.equalsIgnoreCase("true") || parameter.equalsIgnoreCase("false")) {
            return Boolean.parseBoolean(parameter);
        }
        return parameter;
    }

    private static Method findMethod(Class<?> clazz, String methodName, int parameterCount) throws NoSuchMethodException {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (methodName.equals(method.getName()) && method.getParameterCount() == parameterCount) {
                return method;
            }
        }
        throw new NoSuchMethodException("Метод с именем: " + methodName + " не найден или отсутствуют параметры");
    }

    private static String[] parseParams(String str) {
        return str.split(",\\s*");
    }
}