package com.artnest.springSecurity.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artnest.springSecurity.dto.request.CategoryRequest;
import com.artnest.springSecurity.dto.response.CategoryResponse;
import com.artnest.springSecurity.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

     @PostMapping("/save")
	public ResponseEntity<String> saveCategory(@RequestBody CategoryRequest categoryRequest){
		boolean isDataSaved=categoryService.saveCategory(categoryRequest); 
		return isDataSaved ? ResponseEntity.status(200).body("Category saved successfully"):
			ResponseEntity.status(403).body("Something went wrong");
	}

	@GetMapping("/all")
	public ResponseEntity<List<CategoryResponse>> getAllCategorys() {
	 		List<CategoryResponse> categoryList=categoryService.getAllCategory();
		 	return categoryList.size()>0? ResponseEntity.status(200).body(categoryList):
		 		ResponseEntity.status(404).body(categoryList);
	}

    @PutMapping("/update/{categoryId}")
    public ResponseEntity<String> updatecategory(@PathVariable Long categoryId, @RequestBody CategoryRequest categoryRequest) {
        boolean iscategoryUpdated = categoryService.updateCategory(categoryId, categoryRequest);
            return iscategoryUpdated ? ResponseEntity.status(200).body("category updated successfully") :
                ResponseEntity.status(404).body("category not found with ID: " + categoryId);
    }

    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
        
        boolean iscategoryDeleted = categoryService.deleteCategory(categoryId);
            return iscategoryDeleted ? ResponseEntity.status(200).body("category deleted successfully") :
                ResponseEntity.status(404).body("category not found with ID: " + categoryId);
    }
}
