// src/main/java/com/example/order/application/OrderService.java
package com.example.order.application;

import com.example.order.application.command.AddItemToOrderCommand;
import com.example.order.application.command.CreateOrderCommand;
import com.example.order.application.command.RemoveItemFromOrderCommand;

public interface OrderService {
    void createOrder(CreateOrderCommand command);
    void addItemToOrder(AddItemToOrderCommand command);
    void removeItemFromOrder(RemoveItemFromOrderCommand command);
    void cancelOrder(String orderId);
    void placeOrder(String orderId);
    // Other order-related methods...
}
