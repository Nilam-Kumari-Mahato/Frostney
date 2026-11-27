package com.example.Frostney.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BudgetRequest {
	
	private Long budget_id;
	private Long user_id;
	private BigDecimal budget_amount;
	private LocalDate  budgetMonth;
	
	
	public Long getBudget_id() {
		return budget_id;
	}
	public void setBudget_id(Long budget_id) {
		this.budget_id = budget_id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public BigDecimal getBudget_amount() {
		return budget_amount;
	}
	public void setBudget_amount(BigDecimal budget_amount) {
		this.budget_amount = budget_amount;
	}
	public LocalDate getBudgetMonth() {
		return budgetMonth;
	}
	public void setBudgetMonth(LocalDate budgetMonth) {
		this.budgetMonth = budgetMonth;
	}
	
	
}
