package com.example.Frostney.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Frostney.Entity.Budget;

public interface BudgetRepository extends JpaRepository<Budget , Long> {

}
