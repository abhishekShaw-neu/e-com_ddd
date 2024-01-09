package com.example.shoppingcart.model.valueobject;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Embeddable
public class Quantity {
    private final int value;

    public Quantity(int value) {
        // Add validation
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
