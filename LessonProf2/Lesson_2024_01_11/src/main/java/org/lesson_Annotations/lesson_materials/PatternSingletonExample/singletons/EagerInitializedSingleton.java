package org.lesson_Annotations.lesson_materials.PatternSingletonExample.singletons;

public class EagerInitializedSingleton {

    private static final EagerInitializedSingleton INSTANCE = new EagerInitializedSingleton();

    // private constructor to avoid client applications using the constructor
    private EagerInitializedSingleton() {}

    public static EagerInitializedSingleton getInstance() {
        return INSTANCE;
    }
}
