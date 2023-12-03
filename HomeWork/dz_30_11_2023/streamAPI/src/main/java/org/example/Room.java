package org.example;

public class Room {
    private double area;

    public Room(double area) {
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return String.format("Room: %s", area);
    }
}
