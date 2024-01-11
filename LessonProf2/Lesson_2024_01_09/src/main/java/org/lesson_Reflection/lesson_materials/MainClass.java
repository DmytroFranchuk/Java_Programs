package org.lesson_Reflection.lesson_materials;

import org.lesson_Reflection.lesson_materials.person.ExtendedPerson;
import org.lesson_Reflection.lesson_materials.person.Person;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        // Получить объект Class явно
        Class<Person> c1 = Person.class;
        System.out.println(c1.getName());

        // Получить объект Class по строке имени класса
        try {
            Class<Person> c2 = (Class<Person>) Class.forName("org.lesson_Reflection.lesson_materials.person.Person"); // указывается с пакетом
            System.out.println(c2.getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Получить объект Class по типу данных
        Person person = new Person("Jim", 50);
        Class<Person> c3 = (Class<Person>) person.getClass();
        System.out.println(c3.getName());
        System.out.println();

        // Разные имена класса
        System.out.println("Name: " + c3.getName()); // полное имя с пакетом
        System.out.println("Simple name: " + c3.getSimpleName()); // только имя класса
        System.out.println("Canonical name: " + c3.getCanonicalName()); // имя в спецификации Java
        System.out.println();
        System.out.println("Name of array: " + int[].class.getName());
        System.out.println("Simple name of array: " + int[].class.getSimpleName());
        System.out.println("Canonical name of array: " + int[].class.getCanonicalName());
        System.out.println();

        // Данные о пакете
        Package pkg = c3.getPackage();
        System.out.println(pkg.getName());
        System.out.println();

        // информация о модификаторах в объявлении класса
        int mod = c3.getModifiers();
        System.out.println(mod); // модификаторы в виде кода
        System.out.println(Modifier.isPublic(mod));
        System.out.println(Modifier.isAbstract(mod));
        System.out.println();

        // Данные о классе-предке
        Class<?> persParent = Person.class.getSuperclass();
        System.out.println(persParent.getSimpleName());
        Class<?> persExtParent = ExtendedPerson.class.getSuperclass();
        System.out.println(persExtParent.getSimpleName());
        Class<?>objParent = Object.class.getSuperclass();
        System.out.println(objParent);
        System.out.println();

        // данные о наследуемых интерфейсах
        Class<?>[] personInterfaces = person.getClass().getInterfaces();
        System.out.println(Arrays.stream(personInterfaces).map(Class::getSimpleName).toList());
        Class<?>[] extPersonInterfaces = ExtendedPerson.class.getInterfaces();
        System.out.println(Arrays.stream(extPersonInterfaces).map(Class::getSimpleName).toList());
    }
}