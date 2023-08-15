package Еxample_Test_23_08_15;

import java.util.ArrayList;
import java.util.List;

public class OrderProcessor {
    private List<Order> orders = new ArrayList<>();

    public OrderProcessor() {
    }

    public void addOrder(Order order) {
        if (order == null) {throw new IllegalArgumentException();
        }
        orders.add(order);
    }
    public double calculateTotalRevenue() {
        return orders.stream()
                .mapToDouble(Order::calculateTotalPrice)
                .sum();

    }
    public List<Order> getExpiredOrders(){
        return orders.stream()
                .filter(Order::isOrderExpired)
                .toList();
    }
}
