package com.example.product.service;

import com.example.product.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategories();
    CategoryDTO getCategoryById(Long categoryId);
    void addCategory(CategoryDTO categoryDTO);
}
