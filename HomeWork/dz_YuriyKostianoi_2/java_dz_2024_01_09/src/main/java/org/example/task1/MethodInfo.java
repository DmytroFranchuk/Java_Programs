package org.example.task1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MethodInfo {
    private final String methodName;
    private final int modifiers;
    private final Type returnType;
    private final Parameter[] parameters;
    private final Annotation[] annotations;
    private final Class<?>[] exceptionTypes;

    public MethodInfo(Method method) {
        this.methodName = method.getName();
        this.modifiers = method.getModifiers();
        this.returnType = method.getGenericReturnType();
        this.parameters = method.getParameters();
        this.annotations = method.getAnnotations();
        this.exceptionTypes = method.getExceptionTypes();
    }

    @Override
    public String toString() {
        String returnTypeString = returnType.getTypeName();
        String parametersString = Arrays.stream(parameters)
                .map(parameter -> parameter.getType().getName() + " " + parameter.getName())
                .collect(Collectors.joining(", ", "(", ")"));
        String exceptionsString = Arrays.stream(exceptionTypes)
                .map(Class::getName)
                .collect(Collectors.joining(", ", "[", "]"));
        String annotationsString = Arrays.stream(annotations)
                .map(Annotation::toString)
                .collect(Collectors.joining(", ", "[", "]"));
        return "MethodInfo{" +
                "methodName='" + methodName + '\'' +
                ", modifiers=" + modifiers +
                ", returnType=" + returnTypeString +
                ", parameters=" + parametersString +
                ", annotations=" + annotationsString +
                ", exceptionTypes=" + exceptionsString +
                '}';
    }
}
