package com.example.shoppingcart.service;

import com.example.shoppingcart.model.valueobject.ProductId;
import com.example.shoppingcart.model.valueobject.Quantity;

public interface ShoppingCartManagementService {
    void addItemToCart(String userId, ProductId productId, Quantity quantity);

    void removeItemFromCart(String userId, ProductId productId);

    void updateItemQuantity(String userId, ProductId productId, int newQuantity);

    void clearCart(String userId);
}
