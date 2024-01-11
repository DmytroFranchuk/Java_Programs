package org.lesson_Annotations.lesson_materials.PatternSingletonExample.singletons;

/**
 * Prior to Java 5, the Java memory model had a lot of issues, and the previous approaches used to fail in certain
 * scenarios where too many threads tried to get the instance of the singleton class simultaneously.
 * So Bill Pugh came up with a different approach to create the singleton class using an inner static helper class.
 * Notice the private inner static class that contains the instance of the singleton class. When the singleton class is
 * loaded, SingletonHelper class is not loaded into memory and only when someone calls the getInstance() method,
 * this class gets loaded and creates the singleton class instance.
 * This is the most widely used approach for the singleton class as it doesn’t require synchronization.
 */
public class BillPughSingleton {

    private BillPughSingleton() { }
    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
