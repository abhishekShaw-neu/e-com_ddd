package com.example.product.dto;

import com.example.product.model.valueobject.Price;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Price price;
}
