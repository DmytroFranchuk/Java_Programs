package org.example.task1;

import org.example.task1.Order;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class PaymentGateway {
    private Order order;

    public PaymentGateway(@Qualifier("orderA") Order order) {
        this.order = order;
    }

    @Required
    public void setOrder(Order order) {
        this.order = order;
    }

    public void processPayment() {
        System.out.printf("Оплата по заказу id: %s в размере %s евро за товар <%s> выполнена.", order.getId(),
                order.getPrice(), order.getItem());
    }
}
