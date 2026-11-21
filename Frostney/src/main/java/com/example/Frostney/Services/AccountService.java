package com.example.Frostney.Services;

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
}
