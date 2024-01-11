package org.example.task1;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class ObjectInfo {
    private final MethodInfo[] methodsInfo;

    public ObjectInfo(Object object) {
        this.methodsInfo = addMethod(object);
    }

    public MethodInfo[] getMethodsInfo() {
        return methodsInfo;
    }

    private MethodInfo[] addMethod(Object object) {
        Method[] methods = object.getClass().getDeclaredMethods();
        Arrays.sort(methods, Comparator.comparing(Method::getName));
        MethodInfo[] result = new MethodInfo[methods.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new MethodInfo(methods[i]);
        }
        return result;
    }

    @Override
    public String toString() {
        return "ObjectInfo{" +
                "methodsInfo=" + Arrays.toString(methodsInfo) +
                '}';
    }
}
