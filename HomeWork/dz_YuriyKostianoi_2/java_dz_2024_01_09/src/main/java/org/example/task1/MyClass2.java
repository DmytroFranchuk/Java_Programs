package org.example.task1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Comparator;

public class MyClass2 {
    private double value;

    public MyClass2(double value) {
        this.value = value;
    }

    public static void main(String[] args) {
        MyClass test = new MyClass();
        Class<? extends MyClass> testClass = test.getClass();

        Method[] methods = testClass.getDeclaredMethods();

        Arrays.sort(methods, Comparator.comparing(Method::getName));
        for (Method method : methods) {
            System.out.println(method);
            Parameter[] parameters = method.getParameters();
            Annotation[] annotations = method.getAnnotations();
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            for (Parameter param : parameters) {
//                System.out.println(param.getName() + " : " + param.getType());
            }
//            System.out.println(Arrays.toString(exceptionTypes));

            for (Annotation ant : annotations) {
//                System.out.println(ant);
            }
        }
        System.out.println("===========================================");
        ObjectInfo objectInfo = new ObjectInfo(new MyClass());
        System.out.println(objectInfo);

    }
}
