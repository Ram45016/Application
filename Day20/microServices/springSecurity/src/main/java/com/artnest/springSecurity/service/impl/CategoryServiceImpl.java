package com.artnest.springSecurity.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.artnest.springSecurity.dto.request.CategoryRequest;
import com.artnest.springSecurity.dto.response.CategoryResponse;
import com.artnest.springSecurity.model.ArtUpload;
import com.artnest.springSecurity.model.Category;
import com.artnest.springSecurity.repository.CategoryRepository;
import com.artnest.springSecurity.service.CategoryService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public boolean saveCategory(CategoryRequest categoryRequest) {
      Optional<Category> isCategoryOptional=categoryRepository.existsByName(categoryRequest.getName());
		if(isCategoryOptional.isPresent()){
			var category=Category.builder()
					.name(categoryRequest.getName())
					.id(categoryRequest.getId())
                    .build();
		    categoryRepository.save(category);
			return true;
		}
		else{
			return false;
		}
    }

    @Override
    public List<CategoryResponse> getAllCategory() {
       List<Category> categoryList = categoryRepository.findAll();
		List<CategoryResponse> categoryResponseList = new ArrayList<>();
	
		for (Category category : categoryList) {
			CategoryResponse categoryResponse = new CategoryResponse(); 
			categoryResponse.setId(category.getId());
			categoryResponse.setName(category.getName());
			categoryResponseList.add(categoryResponse);
		}
	
		return categoryResponseList;
    }

    @Override
    public boolean updateCategory(Long categoryId, CategoryRequest categoryRequest) {
        Optional<Category> isPresent=categoryRepository.findById(categoryId);
		if(isPresent.isPresent()){
			var category=Category.builder()
					.name(categoryRequest.getName())
					.id(categoryRequest.getId())
                    .build();
		    categoryRepository.save(category);
			return true;
		}
		else{
			return false;
		}
    }

    @Override
    public boolean deleteCategory(Long categoryId) {
       Optional<Category> categoryOptional = categoryRepository.findById(categoryId);

        if (categoryOptional.isPresent()) {
            categoryRepository.deleteById(categoryId);
            return true;
        } else {
            return false;
        }
    }
    
}
