package org.zadanie.task2;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

// Создайте класс, реализующий паттерн Singleton, с одним полем id. Создайте копию объекта Singleton с помощью:
// 1 Рефлексии
// 2 Сериализации и десериализации
public class Task2 {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.printf("getInstance возвращает %s тот же объект %n", singleton2==singleton1 ? " ":" не");
        Optional<Singleton> copiedWithReflection = copyWithReflection(singleton1);
        copiedWithReflection.ifPresent(value -> System.out.printf("getInstance возвращает %s тот же объект %n",
                value==singleton1 ? " ":" не"));
        Optional<Singleton> copyWithSerialization = copyWithSerialization(singleton1);
        copyWithSerialization.ifPresent(value -> System.out.printf("getInstance возвращает %s тот же объект %n",
                value==singleton1 ? " ":" не"));
}
    private static Optional<Singleton> copyWithReflection(Singleton original) {
        Optional<Singleton> result = Optional.empty();
        Class<Singleton> clazz = (Class<Singleton>) original.getClass();
        try {
            Constructor<Singleton> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            result = Optional.of(constructor.newInstance());
            constructor.setAccessible(false);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private static Optional<Singleton> copyWithSerialization(Singleton original) {
        Optional<Singleton> result = Optional.empty();

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(original);
            try (ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                 ObjectInputStream ois = new ObjectInputStream(bais)) {
                result = Optional.ofNullable((Singleton) ois.readObject());
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
