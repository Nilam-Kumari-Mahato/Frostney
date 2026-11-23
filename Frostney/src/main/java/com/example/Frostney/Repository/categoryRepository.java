package com.example.Frostney.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Frostney.Entity.Category;

public interface categoryRepository extends JpaRepository<Category , Long> {
	
	@Query("""
	        SELECT c FROM Category c
	        WHERE c.category_type = :type
	        AND (c.user IS NULL OR c.user.user_id = :userId)
	    """)
	    List<Category> findCategories(
	        @Param("type") String type,
	        @Param("userId") Long userId
	    );
	
}
