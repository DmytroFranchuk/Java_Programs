package org.example.task2_1_ThreadLocal;

public class Exp3 {
    public static void main(String[] args) {
        UniqueIdGenerator<Client> clientGenerator = new UniqueIdGenerator<>(Client.class, 3);
        UniqueIdGenerator<Product> productGenerator = new UniqueIdGenerator<>(Product.class, 3);
        UniqueIdGenerator<Task> taskGenerator = new UniqueIdGenerator<>(Task.class, 3);

        Thread clientThread = new Thread(clientGenerator);
        Thread productThread = new Thread(productGenerator);
        Thread taskThread = new Thread(taskGenerator);

        clientThread.start();
        productThread.start();
        taskThread.start();


    }
}
