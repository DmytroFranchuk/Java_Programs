package org.lesson_Annotations.lesson_materials.PatternSingletonExample.singletons;

public class ThreadSafeSingletonWithDoubleCheckedLocking {
    private static ThreadSafeSingletonWithDoubleCheckedLocking instance;

    private ThreadSafeSingletonWithDoubleCheckedLocking(){}

    public static ThreadSafeSingletonWithDoubleCheckedLocking getInstanceUsingDoubleLocking() {
        if (instance == null) {
            synchronized (ThreadSafeSingletonWithDoubleCheckedLocking.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingletonWithDoubleCheckedLocking();
                }
            }
        }
        return instance;
    }
}
