package com.example.Frostney.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Frostney.Entity.UserCategory;

public interface  UserCategoryRepository extends JpaRepository<UserCategory , Long>{
	List<UserCategory> findByUser_userId(Long user_id);
	
	List<UserCategory> findByUser_userIdAndCategory_categoryType(
	        Long userId,
	        String categoryType
	    );
	
	@Query("""
		    SELECT CASE WHEN COUNT(uc) > 0 THEN true ELSE false END
		    FROM UserCategory uc
		    WHERE uc.user.userId = :userId
		    AND uc.category.category_id = :categoryId
		""")
		boolean existsSelection(
		    @Param("userId") Long userId,
		    @Param("categoryId") Long categoryId
		);
}
