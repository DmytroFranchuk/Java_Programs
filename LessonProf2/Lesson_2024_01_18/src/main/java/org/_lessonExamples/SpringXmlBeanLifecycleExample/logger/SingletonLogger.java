package org._lessonExamples.SpringXmlBeanLifecycleExample.logger;

import java.io.*;
import java.time.LocalDateTime;

public class SingletonLogger implements Closeable {
    private LogLevel commonLevel = LogLevel.INFO;
    private Writer writer = new OutputStreamWriter(System.out);

    public LogLevel getCommonLevel() {
        return commonLevel;
    }

    public SingletonLogger() {
        System.out.println("Выполнился конструктор SingletonLogger");
    }

    public void setCommonLevel(LogLevel commonLevel) {
        this.commonLevel = commonLevel;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.writer = new OutputStreamWriter(outputStream != null ? outputStream : System.out);
    }

    private boolean isNeedToBeLogged(LogLevel methodLevel) {
        return methodLevel.ordinal() >= commonLevel.ordinal();
    }

    private void log(LogLevel methodLevel, String message) {
        if (!isNeedToBeLogged(methodLevel)) return;
        try {
            writer.write(LocalDateTime.now() + " " + methodLevel + ": " + message + System.lineSeparator());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void warning(String message) {
        log(LogLevel.WARNING, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    @Override
    public void close() {
        System.out.print("Closing the logger ");
        loading();
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void open() {
        this.commonLevel = LogLevel.DEBUG;
        System.out.print("Opening necessary connections: ");
        loading();
    }

    private void loading() {
        for (int i = 0; i <= 100; i++) {
            System.out.printf("%d", i);
            System.out.print("%");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("\b".repeat(String.valueOf(i).length() + 1));
        }
        System.out.println("100%");
    }
}
