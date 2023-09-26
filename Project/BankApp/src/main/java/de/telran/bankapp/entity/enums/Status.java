package de.telran.bankapp.entity.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
//    ACTIVE("ACTIVE"), INACTIVE("INACTIVE"), BLOCKED("BLOCKED");
//
//    private final String value;
//
//    Status(String value) {
//        this.value = value;
//    }
//
//    public String getValue() {
//        return value;
//    }
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE"),
    BLOCKED("BLOCKED");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
