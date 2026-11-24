package com.example.Frostney.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
		name = "UserCategory",
		uniqueConstraints = {
			@UniqueConstraint(
				 columnNames = {"user_id", "category_id"}
			)
		}
)
public class UserCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long usercateogry_id;
	
	@ManyToOne
	@JoinColumn( name= "user_id" , nullable = true)
	private User user;
	
	@ManyToOne
	@JoinColumn( name = "category_id" , nullable = false )
	private Category category;

	public Long getUsercateogry_id() {
		return usercateogry_id;
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
