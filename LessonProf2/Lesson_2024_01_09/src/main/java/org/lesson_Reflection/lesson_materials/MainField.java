package org.lesson_Reflection.lesson_materials;

import org.lesson_Reflection.lesson_materials.person.ExtendedPerson;
import org.lesson_Reflection.lesson_materials.person.Person;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MainField {
    public static void main(String[] args) {
        Person person = new Person("Jim", 50);

        // Получение публичных полей
        Field[] publicFields = person.getClass().getFields();
        List<String> publicFieldNames = getFieldNames(publicFields);
        System.out.println("Person (public) " + publicFieldNames);

        // Получение всех полей
        Field[] personFields = person.getClass().getDeclaredFields();
        List<String> actualFieldNames = getFieldNames(personFields);
        System.out.println("Person " + actualFieldNames);

        // Получение полей класса-наследника
        Person extPerson = new ExtendedPerson("Bob", 25, true);
        Field[] publicExtendedPersonFields = extPerson.getClass().getFields();
        System.out.println("ExtendedPerson (public) " + getFieldNames(publicExtendedPersonFields));
        Field[] extendedPersonFields = extPerson.getClass().getDeclaredFields();
        actualFieldNames = getFieldNames(extendedPersonFields);
        System.out.println("ExtendedPerson " + actualFieldNames);
        System.out.println("ExtendedPerson " + getFieldNames(
                getAllFields(new ArrayList<>(), extPerson.getClass()).toArray(new Field[0])
        ));

        // Сортировка полей по модификатору доступа
        List<String> onlyNotPublic = Arrays.stream(extendedPersonFields)
                .filter(f -> !Modifier.isPublic(f.getModifiers()))
                .map(Field::getName).toList();
        System.out.println("Not public " + onlyNotPublic);

        List<String> onlyFinal = Arrays.stream(extendedPersonFields)
                .filter(f -> Modifier.isFinal(f.getModifiers()))
                .map(Field::getName).toList();
        System.out.println("Final " + onlyFinal);
        System.out.println();

        // Получение одного поля по его имени
        Field nameField;
        try {
            nameField = person.getClass().getDeclaredField("name");
            System.out.println(nameField);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        System.out.println();

        Objects.requireNonNull(nameField);

        // Установка значения поля
        nameField.setAccessible(true); // делаем поле неприватным
        try {
            System.out.println("Значение поля до изменения: " + nameField.get(person));
            nameField.set(person, "Cavabanga");
            System.out.println("Значение поля после изменения: " + nameField.get(person));
            System.out.println("Состояние объекта: " + person);

            // Для получения статического поля не требуется объект
            System.out.println(Person.class.getField("DEFAULT_NAME").get(null));
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

    }

    private static List<String> getFieldNames(Field[] fields) {
        return Arrays.stream(fields).map(field -> field.getName()).toList();
    }

    public static List<Field> getAllFields(List<Field> fields, Class<?> type) {
        fields.addAll(Arrays.asList(type.getDeclaredFields()));

        if (type.getSuperclass() != null) {
            getAllFields(fields, type.getSuperclass()); // получить предка данного типа
        }
        return fields;
    }
}