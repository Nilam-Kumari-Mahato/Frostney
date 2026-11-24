package com.example.Frostney.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Frostney.Entity.Category;
import com.example.Frostney.Repository.UserCategoryRepository;
import com.example.Frostney.Repository.UserRepository;
import com.example.Frostney.Repository.categoryRepository;

@Service
public class CategoryService {
	private final categoryRepository categoryrepository;
	private final UserCategoryRepository userCategoryRepository;
	private final UserRepository userRepository;
	
	public CategoryService(categoryRepository categoryrepository ,  UserCategoryRepository userCategoryRepository , UserRepository userRepository) {
		this.categoryrepository = categoryrepository;
		this.userCategoryRepository = userCategoryRepository; 
		this.userRepository = userRepository;
	}
	
	public List<Category> fetchPredefiendCategoryByType(String category_Type){
		
		List<Category> predefinedCategories = categoryrepository.findDefaultCategories(category_Type);
		
		return predefinedCategories;
	}
}
