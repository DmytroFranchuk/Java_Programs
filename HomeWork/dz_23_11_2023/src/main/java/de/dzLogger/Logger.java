package de.dzLogger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalTime;

public class Logger {
    private LocalDate date;
    private LocalTime time;
    private String messageText;
    private boolean isConsole;
    private Path path;

    public Logger() {
        this.isConsole = true;
    }

    public Logger(Path path) {
        this.path = path;
        this.isConsole = false;
    }

    @Override
    public String toString() {
        date = LocalDate.now();
        time = LocalTime.now();
        return String.format("%tF, %tT, message - %s", date, time, messageText);
    }

    public void toFile(String text) {
        try {
            if (!Files.exists(path)) Files.createFile(path);
            Files.writeString(path, toString() + "\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public void debug(String text) {
        messageText = text;
        if (isConsole) {
            System.out.println(toString());
        } else {
            toFile(messageText);
        }
    }

    public void info(String text) {
        messageText = text;
        if (isConsole) {
            System.out.println(toString());
        } else {
            toFile(messageText);
        }

    }

    public void warning(String text) {
        messageText = text;
        if (isConsole) {
            System.out.println(toString());
        } else {
            toFile(messageText);
        }
    }

    public void error(String text) {
        messageText = text;
        if (isConsole) {
            System.out.println(toString());
        } else {
            toFile(messageText);
        }
    }
}
