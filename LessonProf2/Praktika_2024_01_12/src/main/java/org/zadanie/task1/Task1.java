package org.zadanie.task1;

import org.zadanie.task1.reflect.InvokeFirst;
import org.zadanie.task1.reflect.ReflectionHelper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Создайте аннотацию @InvokeFirst, которой можно помечать методы. Создайте классы Кошка,
// Собака, Умный дом, Родственник. Каждый из экземпляров класса делает что-то, когда Вы
// приходите домой – создайте соответствующий метод. В классах должны быть и другие методы.
// После начала программа сообщает, что Вы дома, после чего для всех классов, у которых
// есть методы, помеченные аннотацией @InvokeFirst, создаётся экземпляр и у данного
// экземпляра вызываются методы, помеченные аннотацией @InvokeFirst.
public class Task1 {
    public static void main(String[] args) {

        List<Class<?>> result = ReflectionHelper.findClassesInPackage("org.zadanie.task1.clases");
        Map<Class<?>, List<Method>> classToMethods = ReflectionHelper.findClassesWithAnnotatedMethod(result, InvokeFirst.class);
        Map<?, List<Method>> objectMethods = classToMethods.entrySet().stream()
                .collect(Collectors.toMap(
                        p -> ReflectionHelper.createObject(p.getKey()),
                        Map.Entry::getValue
                ));
        for (Map.Entry<?, List<Method>> pair : objectMethods.entrySet()) {
            for (Method m : pair.getValue()) {
                try {
                    m.invoke(pair.getKey());
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}