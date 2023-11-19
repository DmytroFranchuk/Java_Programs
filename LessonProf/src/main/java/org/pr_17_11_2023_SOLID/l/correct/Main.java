package org.pr_17_11_2023_SOLID.l.correct;

public class Main {
    public static void main(String[] args) {

        CustomerService service = new CustomerService();

        Customer customer1 = new PrivilegedCustomer(25);
        Customer customer2 = new VipCustomer(25);
        Customer customer3 = new NewCustomer(25);

        System.out.println("Привелег покупатель: ");
        service.makeProducts(customer1);
        System.out.println("Вип покупатель: ");
        service.makeProducts(customer2);
        System.out.println("Новый покупатель");
        service.makeProducts(customer3);
    }
}
