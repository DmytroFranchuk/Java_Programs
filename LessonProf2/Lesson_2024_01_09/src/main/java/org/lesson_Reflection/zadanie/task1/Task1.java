package org.lesson_Reflection.zadanie.task1;

// Исследуйте класс String. Выведите в консоль
// имя полное, простое и каноническое имя класса,
// в каком пакете находится,
// какие модификаторы имеет,
// наследником какого класса является,
// какие интерфейсы наследует.

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        Class<String> clazz = String.class;
        System.out.println(clazz.getName());
        System.out.println(clazz.getCanonicalName());
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getPackageName());

        int mods = clazz.getModifiers();
        System.out.println("isAbstract: " + Modifier.isAbstract(mods));
        System.out.println("isFinal: " + Modifier.isFinal(mods));
        System.out.println("isStatic: " + Modifier.isStatic(mods));
        System.out.println("isPublic: " + Modifier.isPublic(mods));
        System.out.println(clazz);
        Class<?> parent = clazz.getSuperclass();
        System.out.println(parent.getSimpleName());
        Class[] interfaces = clazz.getInterfaces();
        System.out.println(Arrays.stream(interfaces).map(Class::getSimpleName).toList());
    }
}