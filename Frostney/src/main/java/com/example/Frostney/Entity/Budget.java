package com.example.Frostney.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table( name = "Budget")
public class Budget {

	@Id
	private Long budget_id;
	
	private int budget_amount;
	private int spent_amount;
	private int month ;
	private int year;
	
	@ManyToOne
	@JoinColumn( name = "user_id" , nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn( name = "category_id" , nullable = false)
	private Category category;

	public Long getBudget_id() {
		return budget_id;
	}

	public void setBudget_id(Long budget_id) {
		this.budget_id = budget_id;
	}

	public int getBudget_amount() {
		return budget_amount;
	}

	public void setBudget_amount(int budget_amount) {
		this.budget_amount = budget_amount;
	}

	public int getSpent_amount() {
		return spent_amount;
	}

	public void setSpent_amount(int spent_amount) {
		this.spent_amount = spent_amount;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
