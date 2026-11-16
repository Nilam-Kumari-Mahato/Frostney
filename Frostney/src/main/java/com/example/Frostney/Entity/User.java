package com.example.Frostney.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name="USER")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(unique = true, nullable = false)
    private String user_name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
    
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
	
    public User() {
    }

    public User(String username, String email, String password) {
        this.user_name = username;
        this.email = email;
        this.password = password;
    }

	public Long getId() {
		return user_id;
	}

	
	public String getUsername() {
		return user_name;
	}

	public void setUsername(String username) {
		this.user_name = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    
	
}
