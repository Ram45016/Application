package com.artnest.springSecurity.service.impl;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artnest.springSecurity.dto.request.CategoryRequest;
import com.artnest.springSecurity.dto.response.CategoryResponse;
import com.artnest.springSecurity.model.Category;
import com.artnest.springSecurity.repository.CategoryRepository;
import com.artnest.springSecurity.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public boolean saveCategory(CategoryRequest categoryRequest) {
        Optional<Category> existingCategory = categoryRepository.existsByName(categoryRequest.getName());

        if (existingCategory.isEmpty()) {
            Category category = Category.builder()
                    .name(categoryRequest.getName())
                    .build();
            categoryRepository.save(category);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<CategoryResponse> getAllCategory() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList.stream()
                .map(category -> new CategoryResponse(category.getId(), category.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean updateCategory(Long categoryId, CategoryRequest categoryRequest) {
        Optional<Category> existingCategory = categoryRepository.findById(categoryId);

        if (existingCategory.isPresent()) {
            Category category = existingCategory.get();
            category.setName(categoryRequest.getName());
            categoryRepository.save(category);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteCategory(Long categoryId) {
        Optional<Category> existingCategory = categoryRepository.findById(categoryId);
        if (existingCategory.isPresent()) {
            categoryRepository.deleteById(categoryId);
            return true;
        } else {
            return false;
        }
    }
}
