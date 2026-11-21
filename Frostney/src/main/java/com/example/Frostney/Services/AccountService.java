package com.example.Frostney.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Frostney.DTO.AccountRequest;
import com.example.Frostney.Entity.Account;
import com.example.Frostney.Entity.User;
import com.example.Frostney.Repository.AccountRepository;
import com.example.Frostney.Repository.UserRepository;

@Service
public class AccountService {
	
	final AccountRepository accountRepository;
	final UserRepository userRepository;
	
	public AccountService(AccountRepository accountRepository , UserRepository userRepository) {
		this.accountRepository = accountRepository;
		this.userRepository = userRepository;
	}
	
	public String createAccount(Long user_id , AccountRequest account) {
		Optional<User> user = userRepository.findById(user_id);
		
		if(user == null) {
			return " No such user Exists ";
		}
		User load_user = user.get();
		
		Account newacc = new Account();
		newacc.setAccount_name(account.getAccount_name());
		newacc.setAccount_Type(account.getAccount_Type());
		newacc.setBalance(account.getBalance());
		newacc.setUser(load_user);
		
		accountRepository.save(newacc);
		return " Account detail saved";
	}
	
	public Account getAccountById(Long account_id) {
		Optional<Account> acc= accountRepository.findById(account_id);
		
		if(acc.isPresent()) {
			return acc.get();
		}
		return null;
	}
	
	
	public List<Account> getAllAccount(Long user_id){
		if(!userRepository.existsById(user_id)) {
			throw new RuntimeException("User not found");
		}
		return accountRepository.findByUser_userId(user_id);
	}
	
	
	public String updateAccount(Long account_id , AccountRequest req) {
		Account account = accountRepository
				.findByaccountIdAndUser_UserId(account_id, req.getUser_id())
				.orElseThrow(() -> new RuntimeException("Account not found"));
		
		account.setAccount_name(req.getAccount_name());
	    account.setAccount_Type(req.getAccount_Type());
	    account.setBalance(req.getBalance());

	    accountRepository.save(account);

	    return "Account updated successfully";
	}
	
	public Account deleteAccountbyId(Long account_id) {
		Optional<Account> delacc = accountRepository.findById(account_id);
		
		if(delacc.isEmpty()) {
			return null;
		}
		accountRepository.deleteById(account_id);
		return delacc.get();
	}
}
