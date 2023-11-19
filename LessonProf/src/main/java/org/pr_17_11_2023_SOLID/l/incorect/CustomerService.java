package org.pr_17_11_2023_SOLID.l.incorect;

public class CustomerService {
    public void addProduct(Customer customer, Product product) {
        customer.getProducts().add(product);
    }

    public void buyProducts(Customer customer) {
        customer.applyDiscount();
        customer.getProducts().clear();
        System.out.println("Операция успешна. Спасибо за покупку!");
    }
}
