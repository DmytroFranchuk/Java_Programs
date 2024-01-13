package org.example.task1;

public class Order {
    private int id;
    private String item;
    private double price;

    public Order(int id, String item, double price) {
        this.id = id;
        this.item = item;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", price=" + price +
                '}';
    }
}
