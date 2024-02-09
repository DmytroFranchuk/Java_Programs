package org.zadanie.task1.reflect;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class ReflectionHelper {
    private static final String CLASS_TYPE = ".class";

    private ReflectionHelper() {
    }

    public static List<Class<?>> findClassesInPackage(String packageName) {
        List<Class<?>> result = new ArrayList<>();
        if (packageName == null || packageName.isEmpty()) return result;
        String path = packageName.replace(".", "/");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader(); // Получаем classLoader, который может найти все файлы классов
        try {
            Iterator<URL> iterator = classLoader.getResources(path).asIterator();
            while (iterator.hasNext()) {
                File directory = new File(iterator.next().getFile());
                if (!directory.exists()) continue;
                String[] fileNames = directory.list();
                if (fileNames == null) continue;
                for (String file : fileNames) {
                    if (file.endsWith(CLASS_TYPE)) {
                        String className = packageName + "." + file.substring(0, file.length() - CLASS_TYPE.length());
                        try {
                            Class<?> clazz = Class.forName(className);
//                            if (clazz.isAnnotationPresent(annotation))
                            result.add(clazz);
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static Map<Class<?>, List<Method>> findClassesWithAnnotatedMethod(List<Class<?>> classes, Class<? extends Annotation> annotation) {
        Map<Class<?>, List<Method>> result = classes.stream().collect(Collectors.toMap(
                c-> c,
                c-> Arrays.stream(c.getDeclaredMethods()).filter(m->m.isAnnotationPresent(annotation)).toList()
        ));
        return result;
    }

    public static <T> T createObject(Class<T> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    }
