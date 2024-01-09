package com.example.product.repository;

import com.example.product.dto.ProductDTO;
import com.example.product.model.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(Long productId);
    void save(Product product);
}
