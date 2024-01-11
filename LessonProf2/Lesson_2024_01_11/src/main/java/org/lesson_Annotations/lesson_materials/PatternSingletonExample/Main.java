package org.lesson_Annotations.lesson_materials.PatternSingletonExample;

import org.lesson_Annotations.lesson_materials.PatternSingletonExample.singletons.LazyInitializedSingleton;

public class Main {
    public static void main(String[] args) {
        LazyInitializedSingleton lazy1 = LazyInitializedSingleton.getInstance();
        LazyInitializedSingleton lazy2 = LazyInitializedSingleton.getInstance();
        System.out.println(lazy1 == lazy2);
    }
}