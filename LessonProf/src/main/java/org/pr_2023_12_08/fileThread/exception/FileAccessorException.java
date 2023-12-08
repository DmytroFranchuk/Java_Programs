package org.pr_2023_12_08.fileThread.exception;

public class FileAccessorException extends RuntimeException {
    public FileAccessorException(String message) {
        super(message);
    }

    public FileAccessorException(String message, Throwable cause) {
        super(message, cause);
    }
}
