package com.example.Frostney.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Frostney.DTO.BudgetRequest;
import com.example.Frostney.Entity.Budget;
import com.example.Frostney.Services.BudgetService;

@RestController
@RequestMapping("/api/budget")
public class BudgetController {
	
	private BudgetService budgetService ;
	
	public BudgetController(BudgetService budgetService) {
		this.budgetService = budgetService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> addBudegt(@RequestBody BudgetRequest request){
		String response = budgetService.addBudget(request);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/get/{budget_id}")
	public ResponseEntity<Budget> getBudgetbyBid(@PathVariable Long budget_id){
		Budget budget = budgetService.getBudget(budget_id);
		
		return ResponseEntity.ok(budget);
	}
	
	@GetMapping("/user/{userId}")
	public Budget getBudgetByUserId(
	        @PathVariable Long userId) {

	    return budgetService.getBudgetByUserId(userId);
	}
}
