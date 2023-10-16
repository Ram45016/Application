package com.artnest.springSecurity.service;

import java.util.List;

import com.artnest.springSecurity.dto.request.CategoryRequest;
import com.artnest.springSecurity.dto.response.CategoryResponse;

public interface CategoryService {

    boolean saveCategory(CategoryRequest categoryRequest);

    List<CategoryResponse> getAllCategory();

    boolean updateCategory(Long categoryId, CategoryRequest categoryRequest);

    boolean deleteCategory(Long categoryId);
    
}
