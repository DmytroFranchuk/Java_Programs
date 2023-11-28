package org.pr_2023_11_17_SOLID.o.incorect;

public class CustomerService {
    public void addProduct(Customer customer, Product product) {
        customer.getProducts().add(product);
    }
}
