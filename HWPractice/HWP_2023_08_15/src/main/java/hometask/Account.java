package hometask;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Account {
    public enum Zone {
        ZONE_1, ZONE_2, ZONE_3
    }

    private String id;
    private boolean status;
    private Zone zone;
    private double balance;

    private static String generateId(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be positive");
        }
        return IntStream.range(0, length)
                .mapToObj(i -> (char) ('a' + i % 26))
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    public Account() {
        this.id = generateId(6);
        this.status = true;
        this.zone = Zone.ZONE_1;
        this.balance = balance;
    }

    public Account(boolean status, Zone zone, double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("must be positive");
        }
        this.id = generateId(6);
        this.status = status;
        this.zone = zone;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public boolean getStatus() {
        return status;
    }

    public Zone getZone() {
        return zone;
    }

    public double getBalance() {
        return balance;
    }
}