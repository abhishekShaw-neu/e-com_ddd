package com.example.shoppingcart.model.entity;

import com.example.shoppingcart.model.valueobject.ProductId;
import com.example.shoppingcart.model.valueobject.Quantity;

public class CartItem {
    private final ProductId productId;
    private Quantity quantity;

    public CartItem(ProductId productId, Quantity quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public ProductId getProductId() {
        return productId;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void increaseQuantity(int amount) {
        // Add validation
        this.quantity = new Quantity(this.quantity.getValue() + amount);
    }

    public void decreaseQuantity(int amount) {
        // Add validation
        int newQuantity = this.quantity.getValue() - amount;
        this.quantity = new Quantity(Math.max(newQuantity, 0));
    }
}
