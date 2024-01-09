package com.example.shoppingcart.model.valueobject;


import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Embeddable
public class ProductId {
    private final String value;

    public ProductId(String value) {
        // Add validation
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}