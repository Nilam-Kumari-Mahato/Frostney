package com.example.Frostney.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Frostney.Entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction , Long>{
	List<Transaction> findByUser_userId(Long user_id);
	
	
	@Query("""
		    SELECT t
		    FROM Transaction t
		    WHERE t.user.userId = :userId
		    AND t.transaction_type = :type
		""")
		List<Transaction> findTransactionsByUserAndType(
		        @Param("userId") Long userId,
		        @Param("type") String type
		);
	
	
	@Query("""
		    SELECT t
		    FROM Transaction t
		    WHERE t.user.userId = :userId
		    AND t.account.accountId = :accountId
		""")
		List<Transaction> findTransactionsByUserAndAccount(
		        @Param("userId") Long userId,
		        @Param("accountId") Long accountId
		);
}
