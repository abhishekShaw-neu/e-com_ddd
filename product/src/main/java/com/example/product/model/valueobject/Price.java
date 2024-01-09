package com.example.product.model.valueobject;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Price {
    private double value;
    private String currency;
}
