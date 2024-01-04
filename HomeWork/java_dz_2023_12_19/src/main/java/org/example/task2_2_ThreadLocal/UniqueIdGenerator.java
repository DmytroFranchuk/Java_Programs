package org.example.task2_2_ThreadLocal;

public class UniqueIdGenerator {

    public static int generateUniqueId(Object obj) {
        if (obj instanceof ClientId) {
            return ((ClientId) obj).getId();
        } else if (obj instanceof ProductId) {
            return ((ProductId) obj).getId();
        } else if (obj instanceof TaskId) {
            return ((TaskId) obj).getId();
        } else {
            throw new IllegalArgumentException("Unsupported type");
        }
    }

}
