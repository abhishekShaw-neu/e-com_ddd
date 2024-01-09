// src/main/java/com/example/order/application/commands/CreateOrderCommand.java
package com.example.order.application.command;

import com.example.order.model.valueobject.ProductId;
import com.example.order.model.valueobject.Quantity;
import lombok.Value;

import java.util.List;

@Value
public class CreateOrderCommand {
    String orderId;
    String customerId;
    List<OrderItemCommand> orderItems;
}

@Value
class OrderItemCommand {
    ProductId productId;
    Quantity quantity;
}

@Value
public class AddItemToOrderCommand {
    String orderId;
    ProductId productId;
    Quantity quantity;
}

@Value
public class RemoveItemFromOrderCommand {
    String orderId;
    ProductId productId;
}