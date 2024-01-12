package org.example.task1.processor;

import org.example.task1.annotation.EventHandler;
import org.example.task1.reflection.ReflectionHelper;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class EventProcessor {
    public static List<Object> processEvents() {
        List<Object> eventHandlers = new ArrayList<>();
        List<Class<?>> handlerClasses = ReflectionHelper.getClassesWithAnnotation("org.example.task1.handlers", EventHandler.class);
        for (Class<?> handlerClass : handlerClasses) {
            try {
                Constructor<?> constructor = handlerClass.getDeclaredConstructor();
                Object handlerInstance = constructor.newInstance();
                eventHandlers.add(handlerInstance);
            } catch (NoSuchMethodException | InstantiationException |
                     IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return eventHandlers;
    }
}
