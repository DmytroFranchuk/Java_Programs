package org.pr_2023_11_17_SOLID.l.incorect;

public class Main {
    public static void main(String[] args) {

        CustomerService service = new CustomerService();
        Customer customer1 = new Customer(25);
        service.buyProducts(customer1);

        Customer customer2 = new NewCustomer(25);
        service.buyProducts(customer2);

        Customer customer3 = new PrivilegedCustomer(30);
        service.buyProducts(customer3);
    }
}
