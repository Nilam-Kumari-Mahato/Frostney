package com.example.Frostney.Services;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.example.Frostney.DTO.BudgetRequest;
import com.example.Frostney.Repository.BudgetRepository;
import com.example.Frostney.Repository.UserRepository;
import com.example.Frostney.Entity.Budget;
import com.example.Frostney.Entity.User;

@Service
public class BudgetService {
	private final BudgetRepository budgetRepository;
	private final UserRepository userRepository;
	
	public BudgetService(BudgetRepository budgetRepository , UserRepository userRepository) {
		this.budgetRepository = budgetRepository;
		this.userRepository = userRepository;
	}
	
	public String addBudget(BudgetRequest req) {
		User user = userRepository.findById(req.getUser_id())
	            .orElseThrow(() -> new RuntimeException("User not found"));
		
		Budget budget = new Budget();
		
		budget.setUser(user);
		budget.setBudget_amount(req.getBudget_amount());
		budget.setBudgetMonth(req.getBudgetMonth());
		
		budgetRepository.save(budget);
		return "Budget added";
	}
	
	public Budget getBudget(Long budget_id) {
		Budget budget = budgetRepository.findById(budget_id)
				.orElseThrow(() -> new RuntimeException("Budget not found"));
		
		return budget;
		
	}
	
	public Budget getBudgetByUserId(Long userId) {

	    LocalDate currentMonth = LocalDate.now()
	            .withDayOfMonth(1);

	    return budgetRepository
	            .findByUser_UserIdAndBudgetMonth(userId, currentMonth)
	            .orElseThrow(() ->
	                    new RuntimeException("Budget not found for this month"));
	}
}
