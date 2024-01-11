package org.example.task2;

import org.example.task1.MyClass;
import java.lang.reflect.Field;

// Создайте собственный класс для сериализация объекта из задания 1 в JSON.
// Используйте Reflection API для анализа полей объекта и их значений, чтобы динамически создавать JSON-представление
// объекта
public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        MyClass myObject = new MyClass();
        setPrivateField(myObject, "number", 42);
        setPrivateField(myObject, "text", "Hello, World!");
        setPrivateField(myObject, "flag", true);
        setPrivateField(myObject, "value", 3.14);
        System.out.println(myObject.toString());

        JsonSerializer serializer = new JsonSerializer();
        Field privateField = MyClass.class.getDeclaredField("number");
        privateField.setAccessible(true);
        privateField.set(myObject, 99);

        String json = serializer.serialize(myObject);
        System.out.println(json);
    }

    private static void setPrivateField(Object obj, String fieldName, Object value)
            throws NoSuchFieldException, IllegalAccessException {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
