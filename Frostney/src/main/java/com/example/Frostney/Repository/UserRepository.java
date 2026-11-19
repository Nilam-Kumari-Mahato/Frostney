package com.example.Frostney.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Frostney.Entity.User;

public interface UserRepository extends JpaRepository<User , Long> {
	
	boolean existByEmail(String email);
	
	boolean existByUserName(String user_name);
	
	Optional<User> findByEmail(String email);
}
