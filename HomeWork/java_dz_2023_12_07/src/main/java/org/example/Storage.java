package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class Storage {
    private int storageSize;
    private DateTimeFormatter formatter;
    private Set<Resource> resources = new HashSet<>(storageSize);


    public Storage() {
        this.storageSize = 10;
        this.formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    }

    public synchronized void add(String nameThread) throws InterruptedException {
        while (resources.size() >= storageSize) {
            // Склад занят мы будем ждать, пока не освободится склад
            wait();
        }
        Resource resource = new Resource();
        resources.add(resource);
        System.out.println(LocalDateTime.now().format(formatter) + " " + nameThread + " " + resource.getId() + " ресурс добавлен");
        // Сигнализируем потребителям, что на складе есть ресурс
        notify();
    }

    public synchronized void remove(String nameThread) throws InterruptedException {
        while (resources.isEmpty()) {
            // Ждем, пока производитель добавит ресурс на склад
            wait();
        }
        Resource removedResource = resources.iterator().next();
        resources.remove(removedResource);
        System.out.println(LocalDateTime.now().format(formatter) + " " + nameThread + " " + removedResource.getId() + " ресурс потреблен");
        // Сигнализируем производителям, что в очереди есть свободное место
        notify();
    }
}
