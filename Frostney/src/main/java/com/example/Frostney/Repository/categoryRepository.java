package com.example.Frostney.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Frostney.Entity.Category;

public interface categoryRepository extends JpaRepository<Category , Long> {

}
