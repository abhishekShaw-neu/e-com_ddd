package com.example.product.service;


import com.example.product.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    private final Map<Long, ProductDTO> products = new HashMap<>();

    @Override
    public List<ProductDTO> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public ProductDTO getProductById(Long productId) {
        return products.get(productId);
    }

    @Override
    public void addProduct(ProductDTO productDTO) {
        // For simplicity, assuming productDTO has an ID field.
        if (productDTO.getId() == null) {
            throw new IllegalArgumentException("Product ID cannot be null");
        }

        // Assuming you want to overwrite existing product with the same ID.
        products.put(productDTO.getId(), productDTO);
    }
}
