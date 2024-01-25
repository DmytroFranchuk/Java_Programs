package com.example.lesson_2024_01_23.task2_AnnotationConfigApplicationContext.connect;

import com.example.lesson_2024_01_23.task1_properties.ConnectionProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class Connector {
    private final ConnectionProperties connectionProperties;
    @Autowired
    public Connector(ConnectionProperties connectionProperties) {
        this.connectionProperties = connectionProperties;
    }

    public void connect() {
        System.out.println("Пробую установить соединение с хостом " + connectionProperties.host() +
                " портом " + connectionProperties.port());
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(200, 2000));
            System.out.println("Cоединение с хостом " + connectionProperties.host() +
                    " портом " + connectionProperties.port() + " установлено");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
