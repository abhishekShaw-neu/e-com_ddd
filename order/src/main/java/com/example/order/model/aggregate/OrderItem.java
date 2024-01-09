package com.example.order.model.aggregate;

import com.example.order.model.valueobject.ProductId;
import com.example.order.model.valueobject.Quantity;
import com.example.order.model.valueobject.Price;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderItem {
    private final ProductId productId;
    private final Quantity quantity;
    private final Price price;

    public double calculateItemValue() {
        return quantity.getValue() * price.getValue();
    }
}
