package de.dzJava.modelTask2;

public class Car {
    private String brand;
    private int year;
    private double price;
    private Engine engine;

    public Car(String brand, int year, double price, Engine engine) {
        this.brand = brand;
        this.year = year;
        this.price = price;
        this.engine = engine;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", engine=" + engine +
                '}';
    }
}
