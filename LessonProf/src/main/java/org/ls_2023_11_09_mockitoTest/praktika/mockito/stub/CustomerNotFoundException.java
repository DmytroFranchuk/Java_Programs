package org.ls_2023_11_09_mockitoTest.praktika.mockito.stub;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException() {
        super("No such customer found!");
    }
}