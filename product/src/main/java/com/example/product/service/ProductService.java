package com.example.product.service;

import com.example.product.dto.ProductDTO;

import java.util.List;

public interface  ProductService {
    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(Long productId);
    void addProduct(ProductDTO productDTO);
}
