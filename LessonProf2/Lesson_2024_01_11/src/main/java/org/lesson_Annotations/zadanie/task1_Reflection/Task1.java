package org.lesson_Annotations.zadanie.task1_Reflection;

import org.lesson_Annotations.zadanie.task1_Reflection.reflect.Lifeforms;
import org.lesson_Annotations.zadanie.task1_Reflection.reflect.ReflectionHelper;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

// Создайте классы Human, Robot, Animal в пакете subject.
// Создайте собственную аннотацию @Lifeforms и примените ее к классам Human и Animal.
// Затем напишите класс ReflectionHelper, использующий Reflection API, который по названию пакета получит
// все классы, отмеченные аннотацией @Lifeforms.
// В методе main выведите названия всех найденных классов.
// Для каждого класса создайте по одному объекту, используя рефлексию и конструктор по умолчанию.
// Добавьте класс BioRobot, который расширяет класс Robot. Укажите аннотацию @Lifeforms над классом BioRobot.
// Проверьте, что новый класс находится
public class Task1 {
    public static void main(String[] args) {
        List<Class<?>> listClasses = ReflectionHelper.findAnnotations("org.lesson_Annotations.zadanie.task1.subject", Lifeforms.class);
        System.out.println(crateInstances(listClasses));
    }
    private static List<?> crateInstances(List<Class<?>> listClasses) {
        return listClasses.stream()
                .map(c -> {
                    try {
                        return c.getDeclaredConstructor().newInstance();
                    } catch (InstantiationException | NoSuchMethodException | InvocationTargetException |
                             IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();
    }
}