package com.example.order.service;

import com.example.order.application.command.AddItemToOrderCommand;
import com.example.order.application.command.CreateOrderCommand;
import com.example.order.application.command.RemoveItemFromOrderCommand;

public interface OrderServices {
    void createOrder(CreateOrderCommand command);

    void addItemToOrder(AddItemToOrderCommand command);

    void removeItemFromOrder(RemoveItemFromOrderCommand command);

    void cancelOrder(String orderId);

    void placeOrder(String orderId);
}
