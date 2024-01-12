package org.zadanie.task3.logger;

import java.io.*;
import java.time.LocalDateTime;

public enum Logger implements Closeable {
    INSTANCE;
    private LogLevel level = LogLevel.INFO;
    private Writer writer = new OutputStreamWriter(System.out);

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public void setOutput(OutputStream output) {
        this.writer = output == null ? writer : new OutputStreamWriter(output);
    }

    private boolean isNeedToBeLogged(LogLevel methodLevel) {
        return methodLevel.ordinal() >= level.ordinal();
    }

    private void log(LogLevel methodLevel, String message) {
        if (!isNeedToBeLogged(methodLevel)) return;
        try {
            writer.write(LocalDateTime.now() + " : " + methodLevel + " : " + message + System.lineSeparator());
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
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
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
