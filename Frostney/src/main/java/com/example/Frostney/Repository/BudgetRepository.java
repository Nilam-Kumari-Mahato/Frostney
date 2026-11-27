package com.example.Frostney.Repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Frostney.Entity.Budget;

public interface BudgetRepository extends JpaRepository<Budget , Long> {
	Optional<Budget> findByUser_UserIdAndBudgetMonth(
	        Long userId,
	        LocalDate budgetMonth
	);
}
