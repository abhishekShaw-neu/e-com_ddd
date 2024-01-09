package com.example.order.repository;

import com.example.order.model.aggregate.Order;
import com.example.order.model.aggregate.OrderStatus;

import java.util.List;

public interface OrderRepository {
    void save(Order order);
    Order findById(String orderId);
    List<Order> findByCustomerIdAndStatus(String customerId, OrderStatus status);
    // Other methods...
}
