package com.example.shoppingcart.model.aggregate;

import com.example.shoppingcart.model.entity.CartItem;
import com.example.shoppingcart.model.valueobject.ProductId;
import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class ShoppingCartAggregate {
    private final String userId;
    private final List<CartItem> cartItems;

    // Default constructor for Spring to instantiate the bean
    public ShoppingCartAggregate() {
        this.userId = "defaultUserId";  // You can replace this with logic to fetch the user ID
        this.cartItems = new ArrayList<>();
    }

    public List<CartItem> getCartItems() {
        return new ArrayList<>(cartItems);
    }

    public void addCartItem(CartItem cartItem) {
        // Add validation if necessary
        cartItems.add(cartItem);
    }

    public void removeCartItem(ProductId productId) {
        // Add validation if necessary
        cartItems.removeIf(item -> item.getProductId().equals(productId));
    }

    public void updateCartItemQuantity(ProductId productId, int newQuantity) {
        // Add validation if necessary
        cartItems.forEach(item -> {
            if (item.getProductId().equals(productId)) {
                item.increaseQuantity(newQuantity - item.getQuantity().getValue());
            }
        });
    }

    public void clearCart() {
        cartItems.clear();
    }
}
