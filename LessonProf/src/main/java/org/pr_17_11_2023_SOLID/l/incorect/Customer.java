package org.pr_17_11_2023_SOLID.l.incorect;


import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int age;
    private List<Product> products = new ArrayList<>();

    public Customer(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void applyDiscount() {
        System.out.println("Скидка применена.");
    }
}
