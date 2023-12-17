package org.pr_2023_12_08.fileThread.exception;

public class ReaderException extends RuntimeException {
    public ReaderException(String message) {
        super(message);
    }

    public ReaderException(String message, Throwable cause) {
        super(message, cause);
    }
}
