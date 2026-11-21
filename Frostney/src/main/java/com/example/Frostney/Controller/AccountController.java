package com.example.Frostney.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Frostney.DTO.AccountRequest;
import com.example.Frostney.Entity.Account;
import com.example.Frostney.Services.AccountService;

@RestController
@RequestMapping("/api/account")
public class AccountController {
	final AccountService accountService;
	
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> createaccount(@RequestBody AccountRequest acc){
		String res = accountService.createAccount(acc.getUser_id(), acc);
		
		return ResponseEntity.ok(res);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Account> getAccountbyId(@PathVariable int id ){
		Long account_id = (long) id;
		Account load_acc = accountService.getAccountById(account_id);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(load_acc);
	}
	
	@GetMapping("/getAll/{id}")
	public ResponseEntity<List<Account>> getAllaccount(@PathVariable int id){
		Long user_id = (long) id;
		List<Account> accounts = accountService.getAllAccount(user_id);
		
		return ResponseEntity.ok(accounts);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateAccountdetail(@PathVariable int id , @RequestBody AccountRequest acc) {
		Long account_id = (long) id;
		
		String res = accountService.updateAccount(account_id, acc);
		
		return ResponseEntity.ok(res);		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Account> deleteAccountbyId(@PathVariable int id){
		Long account_id = (long) id;
		Account deleted_acc = accountService.deleteAccountbyId(account_id);
		
		return ResponseEntity.ok(deleted_acc);
	}
}
