package com.example.shoppingcart.controller;

import com.example.shoppingcart.model.valueobject.ProductId;
import com.example.shoppingcart.model.valueobject.Quantity;
import com.example.shoppingcart.service.ShoppingCartManagementService;
import com.example.shoppingcart.service.ShoppingCartService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/shopping-cart")
public class ShoppingCartController {
    private final ShoppingCartManagementService shoppingCartManagementService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartManagementService = shoppingCartService;
    }

    @PostMapping("/{userId}/add-item")
    public void addItemToCart(
            @PathVariable String userId,
            @RequestParam String productId,
            @RequestParam int quantity
    ) {
        shoppingCartManagementService.addItemToCart(userId, new ProductId(productId), new Quantity(quantity));
    }

    @PostMapping("/{userId}/remove-item")
    public void removeItemFromCart(
            @PathVariable String userId,
            @RequestParam String productId
    ) {
        shoppingCartManagementService.removeItemFromCart(userId, new ProductId(productId));
    }

    @PostMapping("/{userId}/update-quantity")
    public void updateItemQuantity(
            @PathVariable String userId,
            @RequestParam String productId,
            @RequestParam int quantity
    ) {
        shoppingCartManagementService.updateItemQuantity(userId, new ProductId(productId), quantity);
    }

    @PostMapping("/{userId}/clear-cart")
    public void clearCart(@PathVariable String userId) {
        shoppingCartManagementService.clearCart(userId);
    }
}