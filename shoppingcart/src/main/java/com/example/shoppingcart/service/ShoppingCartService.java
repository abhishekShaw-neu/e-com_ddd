package com.example.shoppingcart.service;

import com.example.shoppingcart.model.aggregate.ShoppingCartAggregate;
import com.example.shoppingcart.model.entity.CartItem;
import com.example.shoppingcart.model.valueobject.ProductId;
import com.example.shoppingcart.model.valueobject.Quantity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService implements ShoppingCartManagementService {
    private final ShoppingCartAggregate shoppingCartAggregate;
    private final String defaultUserId;  //  default or fetch it from another source

    @Autowired
    public ShoppingCartService(ShoppingCartAggregate shoppingCartAggregate) {
        this.shoppingCartAggregate = shoppingCartAggregate;
        this.defaultUserId = "defaultUserId";  // replace this with logic to fetch the user ID
    }

    @Override
    public void addItemToCart(String userId, ProductId productId, Quantity quantity) {
        // Use userId or defaultUserId as needed
        userId = (userId != null) ? userId : defaultUserId;

        CartItem cartItem = new CartItem(productId, quantity);
        shoppingCartAggregate.addCartItem(cartItem);
    }

    @Override
    public void removeItemFromCart(String userId, ProductId productId) {
        // Use userId or defaultUserId
        userId = (userId != null) ? userId : defaultUserId;

        shoppingCartAggregate.removeCartItem(productId);
    }

    @Override
    public void updateItemQuantity(String userId, ProductId productId, int newQuantity) {
        // Use userId or defaultUserId
        userId = (userId != null) ? userId : defaultUserId;

        shoppingCartAggregate.updateCartItemQuantity(productId, newQuantity);
    }

    @Override
    public void clearCart(String userId) {
        // Use userId or defaultUserId
        userId = (userId != null) ? userId : defaultUserId;

        shoppingCartAggregate.clearCart();
    }
}
