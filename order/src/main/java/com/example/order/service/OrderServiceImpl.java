package com.example.order.service;
import com.example.order.application.OrderService;
import com.example.order.application.command.AddItemToOrderCommand;
import com.example.order.application.command.CreateOrderCommand;
import com.example.order.application.command.RemoveItemFromOrderCommand;
import com.example.order.model.aggregate.Order;
import com.example.order.model.aggregate.OrderStatus;
import com.example.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService, OrderServices {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void createOrder(CreateOrderCommand command) {
        Order order = new Order(command.getOrderId(), command.getCustomerId(), command.getOrderItems(), OrderStatus.CREATED);
        orderRepository.save(order);
    }

    @Override
    public void addItemToOrder(AddItemToOrderCommand command) {
        Order order = orderRepository.findById(command.getOrderId());
        if (order != null && order.getOrderStatus() == OrderStatus.CREATED) {
            // Add validation and logic for adding an item to the order
        }
    }

    @Override
    public void removeItemFromOrder(RemoveItemFromOrderCommand command) {
        Order order = orderRepository.findById(command.getOrderId());
        if (order != null && order.getOrderStatus() == OrderStatus.CREATED) {
            // Add validation and logic for removing an item from the order
        }
    }

    @Override
    public void cancelOrder(String orderId) {
        Order order = orderRepository.findById(orderId);
        if (order != null && (order.getOrderStatus() == OrderStatus.CREATED || order.getOrderStatus() == OrderStatus.PLACED)) {
            order.cancelOrder();
            orderRepository.save(order);
            // Publish an event for order cancellation
            //publishOrderCanceledEvent(new OrderCanceledEvent(orderId));
        }
    }

    @Override
    public void placeOrder(String orderId) {
        Order order = orderRepository.findById(orderId);
        if (order != null && order.getOrderStatus() == OrderStatus.CREATED) {
            order.placeOrder();
            orderRepository.save(order);
            // Publish an event for order placement
            //publishOrderPlacedEvent(new OrderPlacedEvent(orderId));
        }
    }

    // Implement other order-related methods...
/*
    private void publishOrderCanceledEvent(OrderCanceledEvent event) {
        // Implement logic for publishing the event
    }

    private void publishOrderPlacedEvent(OrderPlacedEvent event) {
        // Implement logic for publishing the event
    }

 */
}
