package com.example.shoppingcart.repository;

import com.example.shoppingcart.model.aggregate.ShoppingCartAggregate;

public interface ShoppingCartRepository {
    ShoppingCartAggregate findByUserId(String userId);

    void save(ShoppingCartAggregate shoppingCartAggregate);
}
