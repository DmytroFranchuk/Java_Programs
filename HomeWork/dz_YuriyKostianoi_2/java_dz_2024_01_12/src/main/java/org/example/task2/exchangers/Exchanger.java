package org.example.task2.exchangers;

import org.example.task2.connections.Connection;
import org.example.task2.connections.Connector;

import java.time.LocalDateTime;

public class Exchanger implements Runnable {
    private final String name;
    private final Connection connection;

    public Exchanger(String name) {
        this.name = name;
        this.connection = Connector.getConnection();
    }

    @Override
    public void run() {
        System.out.printf("%s %s получил %s соединение с id %s [порт - %s, протокол - %s]%n", LocalDateTime.now(),
                name,
                connection.getHost(),
                connection.getId(),
                connection.getPort(),
                connection.getProtocol());
    }
}
