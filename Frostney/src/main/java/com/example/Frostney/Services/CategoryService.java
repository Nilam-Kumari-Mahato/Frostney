package com.example.Frostney.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Frostney.DTO.CategoryRequest;
import com.example.Frostney.DTO.CategorySetupRequest;
import com.example.Frostney.Entity.Category;
import com.example.Frostney.Entity.User;
import com.example.Frostney.Entity.UserCategory;
import com.example.Frostney.Repository.UserCategoryRepository;
import com.example.Frostney.Repository.UserRepository;
import com.example.Frostney.Repository.categoryRepository;

import jakarta.transaction.Transactional;

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
	
	@Transactional
	public String selectpredefienedCategories(Long userId, List<Long> category_ids) {

	    // 1. Check whether user exists
	    User user = userRepository.findById(userId)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    // 2. Check whether category IDs were provided
	    if (category_ids == null || category_ids.isEmpty()) {
	        throw new RuntimeException("Please select at least one category");
	    }

	    // 3. Fetch categories using the provided IDs
	    List<Category> categories = categoryrepository.findAllById(category_ids);

	    // 4. Check whether all category IDs exist
	    if (categories.size() != category_ids.size()) {
	        throw new RuntimeException("One or more category IDs are invalid");
	    }

	    // 5. Create UserCategory relationships
	    List<UserCategory> userCategories = new ArrayList<>();

	    for (Category category : categories) {

	        // Check whether the category is predefined
	        if (!category.isIs_default()) {
	            throw new RuntimeException("Only predefined categories can be selected");
	        }

	        // Avoid duplicate selection
	        if (userCategoryRepository.existsSelection(user.getId(), category.getCategory_id())) {
	            continue;
	        }

	        UserCategory userCategory = new UserCategory();

	        userCategory.setUser(user);
	        userCategory.setCategory(category);

	        userCategories.add(userCategory);
	    }

	    // 6. Save all relationships
	    userCategoryRepository.saveAll(userCategories);

	    return "Predefined categories selected successfully";
	}
	
	@Transactional
	public String setupCategories(CategorySetupRequest req) {

	    // 1. Check whether user exists
	    User user = userRepository.findById(req.getUser_id())
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    // 2. Save predefined category selections
	    if (req.getSelected_category_ids() != null
	            && !req.getSelected_category_ids().isEmpty()) {

	        selectpredefienedCategories(
	                req.getUser_id(),
	                req.getSelected_category_ids()
	        );
	    }

	    // 3. Create custom categories
	    if (req.getCustom_categories() != null) {

	        for (CategoryRequest custom : req.getCustom_categories()) {

	            Category category = new Category();

	            category.setCategory_Name(custom.getCategory_name());
	            category.setCategory_Type(custom.getCategory_type());
	            category.setIs_default(false);
	            category.setUser(user);

	            // Save custom category in Category table
	            Category savedCategory = categoryrepository.save(category);

	            // 4. Map custom category to the user
	            UserCategory userCategory = new UserCategory();

	            userCategory.setUser(user);
	            userCategory.setCategory(savedCategory);

	            userCategoryRepository.save(userCategory);
	        }
	    }

	    return "Categories setup successfully";
	}
}
