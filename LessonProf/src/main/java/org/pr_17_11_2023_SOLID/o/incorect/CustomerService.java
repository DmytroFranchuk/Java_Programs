package org.pr_17_11_2023_SOLID.o.incorect;

public class CustomerService {
    public void addProduct(Customer customer, Product product) {
        customer.getProducts().add(product);
    }
}
