package com.example.Frostney.DTO;

import java.time.LocalDate;

public class TransactionRequest {
	
	private Long transaction_id;
	private Long userId;
	private Long account_id;
	private Long category_id;
	
	private int amount;
	private String t_description;
	private String transaction_type;
	private LocalDate transaction_date;
	
	
	
	public void setTransaction_id(Long transaction_id) {
		this.transaction_id = transaction_id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getAccount_id() {
		return account_id;
	}
	public void setAccount_id(Long account_id) {
		this.account_id = account_id;
	}
	public Long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getT_description() {
		return t_description;
	}
	public void setT_description(String t_description) {
		this.t_description = t_description;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public LocalDate getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(LocalDate transaction_date) {
		this.transaction_date = transaction_date;
	}
	
	
}
