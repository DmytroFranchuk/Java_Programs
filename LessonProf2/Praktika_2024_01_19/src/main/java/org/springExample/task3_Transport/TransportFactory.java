package org.springExample.task3_Transport;

public class TransportFactory {
    public Transport createTransport(String type) {
        switch (type.toLowerCase()) {
            case "car":
                return new Car();
            case "bicycle":
                return new Bicycle();
            case "motorcycle":
                return new Motorcycle();
            default:
                throw new IllegalArgumentException("Такой транспорт не производим: " + type);
        }
    }
}
