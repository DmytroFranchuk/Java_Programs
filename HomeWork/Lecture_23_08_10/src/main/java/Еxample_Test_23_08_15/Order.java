package Еxample_Test_23_08_15;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.List;
import java.util.Objects;

public class Order {
    private final int orderId;
    private final Person customer;
    private final List<Product> products;
    private final LocalDate orderDate;

    public Order(int orderId, Person customer, List<Product> products, LocalDate orderDate) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = products;
        this.orderDate = orderDate;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public int getNumberOfProducts() {
        return products.size();
    }

    public boolean isOrderExpired() {
        return orderDate.isBefore(LocalDate.now());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && Objects.equals(customer, order.customer) && Objects.equals(products, order.products) && Objects.equals(orderDate, order.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customer, products, orderDate);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customer=" + customer +
                ", products=" + products +
                ", orderDate=" + orderDate +
                '}';
    }

    public int getOrderId() {
        return orderId;
    }

    public Person getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }
}
