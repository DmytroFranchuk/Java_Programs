package org.pr_2023_11_17_SOLID.o.incorect;

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
}
