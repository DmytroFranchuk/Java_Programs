package com.example.lesson_2024_01_23.task1_properties;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public final class ConnectionProperties {
    @Value("${connect.host}")
    private final String host;
    @Value("${connect.port}")
    private final int port;

    @Value("${connect.token}")
    private String token;

    public ConnectionProperties(
            @Value("${connect.host}") String host,
            @Value("${connect.port}") int port,
            @Value("${connect.token}") String token) {
        this.host = host;
        this.port = port;
        this.token = token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @PostConstruct
    public void logData() {
//        setToken(UUID.randomUUID().toString());
        System.out.println("Init: " + this);
    }

    @PreDestroy
    public void writeData() {
        Path path = Path.of("C:\\Java\\2\\Java_Programs\\LessonProf2\\Lesson_2024_01_23\\target\\classes\\application.properties");
        try {
            List<String> lines = Files.readAllLines(path);
            String newProps = lines.stream()
                    .map(e -> e.contains("connect.token=") ? "connect.token=" + this.token : e)
                    .collect(Collectors.joining(System.lineSeparator()));

            Files.writeString(path, newProps, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Value("${connect.host}")
    public String host() {
        return host;
    }

    @Value("${connect.port}")
    public int port() {
        return port;
    }

    @Value("${connect.token}")
    public String token() {
        return token;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ConnectionProperties) obj;
        return Objects.equals(this.host, that.host) &&
                this.port == that.port &&
                Objects.equals(this.token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(host, port, token);
    }

    @Override
    public String toString() {
        return "ConnectionProperties[" +
                "host=" + host + ", " +
                "port=" + port + ", " +
                "token=" + token + ']';
    }


}
