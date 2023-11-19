package org.pr_17_11_2023_SOLID.l.correct;

public class CustomerService {
    public void addProduct(Customer customer, Product product) {
        customer.getProducts().add(product);
    }

    public void makeProducts(Customer customer) {
        customer.buyProducts();
        System.out.println("Операция успешна. Спасибо за покупку!");
    }
}
