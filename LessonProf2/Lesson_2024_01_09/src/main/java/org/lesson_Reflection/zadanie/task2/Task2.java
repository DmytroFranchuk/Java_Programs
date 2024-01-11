package org.lesson_Reflection.zadanie.task2;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Создайте иерархию классов световых приборов с тремя поколениями. Например,
// 1. световой прибор (яркость свечения, цвет)
// 2. электрическая лампа (потребляемая мощность, тип цоколя)
// 3. умная лампа (перечень доступных функций, тип подключения к сети передачи данных)
// Составьте мапу, в которой классу иерархии будут соответствовать его приватные поля.
// Выведите мапу в консоль.
// Всем строковым полям присвойте значение «abc».
public class Task2 {
    public static void main(String[] args) {
        SmartBulb smartBulb = new SmartBulb();
        Map<Class<?>, List<String>> classToFields = new HashMap<>();
        Class<?> clazz = SmartBulb.class;
        while (clazz != null) {
            Field[] fields = clazz.getDeclaredFields();
            classToFields.put(clazz, Arrays.stream(fields).map(Field::getName).toList());
            clazz = clazz.getSuperclass();
        }
        classToFields.forEach((k, v) -> System.out.println(k.getSimpleName() + "\t" + v));

        classToFields.forEach((k, v) -> {
            v.forEach(f -> {
                try {
                    Field field = k.getDeclaredField(f);
                    if (field.getType().equals(String.class)) {
                        field.setAccessible(true);
                        System.out.println("Поле: " + f + " старое значение: " + field.get(smartBulb));
                        field.set(smartBulb, "abc");
                        System.out.println("Поле: " + f + " новое значение: " + field.get(smartBulb));
                        field.setAccessible(false);
                    }
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            });
        });
    }
}
