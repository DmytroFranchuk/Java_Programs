package org.pr_2023_12_08.fileThread.exception;

public class LoggerException extends RuntimeException {
    public LoggerException(String message) {
        super(message);
    }

    public LoggerException(String message, Throwable cause) {
        super(message, cause);
    }
}
