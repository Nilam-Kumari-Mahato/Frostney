package com.example.Frostney.Services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Frostney.Repository.categoryRepository;
import com.example.Frostney.DTO.TransactionRequest;
import com.example.Frostney.Repository.AccountRepository;
import com.example.Frostney.Repository.TransactionRepository;
import com.example.Frostney.Repository.UserRepository;
import com.example.Frostney.Entity.Account;
import com.example.Frostney.Entity.Category;
import com.example.Frostney.Entity.Transaction;
import com.example.Frostney.Entity.User;

@Service
public class TransactionService {
	
	private final TransactionRepository transactionRepository;
	private final UserRepository userrepository;
	private final AccountRepository accountRepository;
	private final categoryRepository categoryRepository;
	
	
	
	public TransactionService(TransactionRepository transactionRepository, UserRepository userrepository,
			AccountRepository accountRepository, categoryRepository categoryRepository) {
		this.transactionRepository = transactionRepository;
		this.userrepository = userrepository;
		this.accountRepository = accountRepository;
		this.categoryRepository = categoryRepository;
	}



	public String addTransaction(TransactionRequest req ) {
		
		Long user_id = req.getUserId();
		Long account_id = req.getAccount_id();
		Long category_id = req.getCategory_id();
		
		User user = userrepository.findById(user_id)
				.orElseThrow(() -> new RuntimeException("User not found"));
		Account account = accountRepository.findById(account_id)
				.orElseThrow(() -> new RuntimeException("Account not found"));
		
		Category category = categoryRepository.findById(category_id)
				.orElseThrow(() -> new RuntimeException("Category not found"));
		
		Transaction newTransc = new Transaction();
		
		newTransc.setUser(user);
		newTransc.setAccount(account);
		newTransc.setTransaction_type(req.getTransaction_type());
		newTransc.setCategory(category);
		newTransc.setAmount(req.getAmount());
		newTransc.setT_description(req.getT_description());
		newTransc.setTransaction_date(req.getTransaction_date());
		
		transactionRepository.save(newTransc);
		
		return " Transaction saved successfully ";
		
	}
}
