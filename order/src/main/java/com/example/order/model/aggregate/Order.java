// src/main/java/com/example/order/model/aggregate/Order.java
package com.example.order.model.aggregate;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Order {
    private final String orderId;
    private final String customerId;
    private final List<OrderItem> orderItems;
    private OrderStatus orderStatus;

    public double calculateTotalOrderValue() {
        return orderItems.stream()
                .mapToDouble(OrderItem::calculateItemValue)
                .sum();
    }

    public void placeOrder() {
        if (this.orderStatus == OrderStatus.CREATED) {
            this.orderStatus = OrderStatus.PLACED;
        } else {
            throw new IllegalStateException("Order can only be placed if it is in CREATED state.");
        }
    }

    public void cancelOrder() {
        if (this.orderStatus == OrderStatus.CREATED || this.orderStatus == OrderStatus.PLACED) {
            this.orderStatus = OrderStatus.CANCELED;
        } else {
            throw new IllegalStateException("Order can only be canceled if it is in CREATED or PLACED state.");
        }
    }
}
