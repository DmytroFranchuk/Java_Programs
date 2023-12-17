package org.pr_2023_12_08.fileThread.exception;

public class WriterException extends RuntimeException {
    public WriterException(String message) {
        super(message);
    }

    public WriterException(String message, Throwable cause) {
        super(message, cause);
    }
}
