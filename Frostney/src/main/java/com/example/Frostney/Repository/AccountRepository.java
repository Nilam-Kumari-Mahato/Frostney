package com.example.Frostney.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Frostney.Entity.Account;

public interface AccountRepository extends JpaRepository<Account , Long>{
	List<Account> findByUser_userId(Long user_id);
	
	Optional<Account> findByaccountIdAndUser_UserId(
	        Long accountId, Long userId
	    );

}
