package com.example.Frostney.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Category")
public class Category {
	
	@Id
	private Long category_id;
	
	private String Category_Name;
	private String category_Type;
	
	private boolean is_default;
	
	@ManyToOne
	@JoinColumn(name = "user_id" , nullable = false)
	private User user;

	public Long getCategory_id() {
		return category_id;
	}

	
	public String getCategory_Name() {
		return Category_Name;
	}

	public void setCategory_Name(String category_Name) {
		Category_Name = category_Name;
	}

	public String getCategory_Type() {
		return category_Type;
	}

	public void setCategory_Type(String category_Type) {
		this.category_Type = category_Type;
	}
	
	

	public boolean isIs_default() {
		return is_default;
	}


	public void setIs_default(boolean is_default) {
		this.is_default = is_default;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
