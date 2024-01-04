package org.example.task2_2_ThreadLocal;
// Создайте классы Клиент, Товар, Задание. Создайте единый механизм для генерации уникальных
// идентификаторов для каждого из классов (у Клиентов свои идентификаторы, у Товаров – свои,
// у Заданий - свои). Используйте обёртку ThreadLocal для хранения счетчика уникальных
// идентификаторов в каждом потоке. Реализуйте класс UniqueIdGenerator, который предоставляет
// метод generateUniqueId(), возвращающий уникальный идентификатор.
public class Main {
    public static void main(String[] args) {
        ClientId clientId1 = new ClientId();
        ClientId clientId2 = new ClientId();

        ProductId productId1 = new ProductId();
        ProductId productId2 = new ProductId();

        TaskId taskId1 = new TaskId();
        TaskId taskId2 = new TaskId();

        int uniqueId1 = UniqueIdGenerator.generateUniqueId(clientId1);
        int uniqueId2 = UniqueIdGenerator.generateUniqueId(clientId2);
        int uniqueId3 = UniqueIdGenerator.generateUniqueId(productId1);
        int uniqueId4 = UniqueIdGenerator.generateUniqueId(productId2);
        int uniqueId5 = UniqueIdGenerator.generateUniqueId(taskId1);
        int uniqueId6 = UniqueIdGenerator.generateUniqueId(taskId2);

        System.out.println("Unique ID for Client 1: " + uniqueId1);
        System.out.println("Unique ID for Client 2: " + uniqueId2);
        System.out.println("Unique ID for Product 1: " + uniqueId3);
        System.out.println("Unique ID for Product 2: " + uniqueId4);
        System.out.println("Unique ID for Task 1: " + uniqueId5);
        System.out.println("Unique ID for Task 2: " + uniqueId6);
    }
}
