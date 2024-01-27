package org.task2.pojo;

public class Connector {

    public Connector() {
        System.out.println("Connector: создание коннектора связи с сервером ... ");
        Delay.delayProgressBar(100);
        System.out.println("Connector: коннектор создан");
    }

    public void connect() {
        System.out.println("Ожидайте идет подключение к серверу...");
        Delay.delayProgressBar(10);
        System.out.println("Соединение успешно установлено ");
    }
}
