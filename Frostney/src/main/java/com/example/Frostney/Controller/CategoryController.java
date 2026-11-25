package com.example.Frostney.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Frostney.DTO.CategorySelectionRequest;
import com.example.Frostney.DTO.CategorySetupRequest;
import com.example.Frostney.Entity.Category;
import com.example.Frostney.Services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	private final CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping("/default/{type}")
	public ResponseEntity<List<Category>> fetchPreCategoriesByType(@PathVariable("type") String category_type){
		List<Category> categories = categoryService.fetchPredefiendCategoryByType(category_type);
		
		return ResponseEntity.ok(categories);
	}
	
	@PostMapping("/setup")
	public ResponseEntity<String> setupCategories(
	        @RequestBody CategorySetupRequest req) {

	    String res = categoryService.setupCategories(req);

	    return ResponseEntity.ok(res);
	}
	
	@GetMapping("/selected/{userId}")
	public List<Category> getSelectedCategories(
	        @PathVariable Long userId) {
	    return categoryService.getSelectedCategories(userId);
	}
}
