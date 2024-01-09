package com.example.product.repository;

import com.example.product.model.entity.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAll();
    Category findById(Long categoryId);
    void save(Category category);
}
