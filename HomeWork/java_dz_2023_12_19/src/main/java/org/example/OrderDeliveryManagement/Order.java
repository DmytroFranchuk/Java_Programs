package org.example.OrderDeliveryManagement;

public final class Order {
    private final int orderId;
    private final int orderCount;
    private final int deliveryTime;
    private final String deliveryAddress;
    private boolean processed;
    private static int lastOrderId = 0;

    public Order(int orderCount, int deliveryTime) {
        this.orderId = ++lastOrderId;
        this.orderCount = orderCount;
        this.deliveryTime = deliveryTime;
        this.deliveryAddress = "house: " + lastOrderId;
        this.processed = false;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public boolean isProcessed() {
        return processed;
    }

    @Override
    public String toString() {
        return "Order { " +
                "orderId=" + orderId +
                ", orderCount=" + orderCount +
                ", deliveryTime=" + deliveryTime +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", processed=" + processed + " " +
                '}';
    }
}
