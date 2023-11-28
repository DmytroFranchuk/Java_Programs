package org.ls_2023_11_09_mockitoTest.praktika.mockito.mock;

public class CreateTradeException extends RuntimeException {
    public CreateTradeException() {
        super("Cannot create such trade!");
    }
}