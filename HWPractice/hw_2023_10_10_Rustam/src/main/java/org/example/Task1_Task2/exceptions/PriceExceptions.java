package org.example.Task1_Task2.exceptions;

public class PriceExceptions extends Throwable{
    public PriceExceptions(String message) {
        super(message);
    }

    public PriceExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
